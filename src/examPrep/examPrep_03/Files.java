package examPrep.examPrep_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by ChaosFire on 31.10.2017 г.
 */
public class Files {

    private static final String NO_RESULT = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int fileCount = Integer.parseInt(reader.readLine());
        Map<String, Set<File>> rootFileMap = new HashMap<>();
        for (int i = 0; i < fileCount; i++) {
            File file;
            try {
                file = File.parseFile(reader.readLine());
            } catch (IllegalArgumentException exc) {
                continue;
            }
            Set<File> files = rootFileMap.get(file.getRoot());
            if (files == null) {
                files = new HashSet<>();
                files.add(file);
                rootFileMap.put(file.getRoot(), files);
            } else {
                files.remove(file);
                files.add(file);
            }
        }
        String[] queryData = reader.readLine().split("\\s+");
        reader.close();

        StringBuilder output = new StringBuilder();
        try {
            rootFileMap.get(queryData[2])
                    .stream()
                    .filter(f -> f.getExtension().equals(queryData[0]))
                    .sorted(fileComparator())
                    .forEach(f -> output.append(f.toString()).append(System.lineSeparator()));
            if (output.length() == 0) {
                output.append(NO_RESULT);
            }
        } catch (Exception exc) {
            output.append(NO_RESULT);
        }
        System.out.print(output);
    }

    private static Comparator<File> fileComparator() {
        Comparator<File> sizeComparator = (x, y) -> y.getSize().compareTo(x.getSize());
        Comparator<File> nameComparator = Comparator.comparing(File::getFullName);
        return sizeComparator.thenComparing(nameComparator);
    }
}

class File {

    private String root;
    private String extension;
    private String fullName;
    private BigInteger size;
    private Integer hash;

    private File(String root, String fileName, String extension, BigInteger size) {
        this.root = root;
        this.extension = extension;
        this.fullName = fileName + "." + extension;
        this.size = size;
        this.hash = null;
    }

    @Override
    public int hashCode() {
        if (this.hash == null) {
            this.hash = this.root.hashCode() * 17 + this.fullName.hashCode() * 31;
        }
        return this.hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File)) {
            return false;
        }
        File other = (File) obj;
        return this.root.equals(other.root) && this.fullName.equals(other.fullName);
    }

    @Override
    public String toString() {
        return String.format("%s - %d KB", this.fullName, this.size);
    }

    String getRoot() {
        return this.root;
    }

    String getExtension() {
        return this.extension;
    }

    String getFullName() {
        return this.fullName;
    }

    BigInteger getSize() {
        return this.size;
    }

    static File parseFile(String string) {
        try {
            String[] data = string.split("\\\\");
            String root = data[0];
            data = data[data.length - 1].split(";");
            BigInteger size = new BigInteger(data[1]);
            int dotIndex = data[0].lastIndexOf('.');
            String fileName = data[0].substring(0, dotIndex);
            String extension = data[0].substring(dotIndex + 1);
            return new File(root, fileName, extension, size);
        } catch (Exception exc) {
            throw new IllegalArgumentException();
        }
    }
}