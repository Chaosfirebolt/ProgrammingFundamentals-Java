package filesExceptions_Lab.folderSize_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ChaosFire on 19.10.2017 г.
 */
public class FolderSize {

    private static final String RESOURCE_PATH = "\\resources\\05. Folder Size";
    private static final double TO_MEGABYTES = 1024 * 1024;
    private static double size = 0;

    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        File file = new File(projectDir + "\\src");
        traverse(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + RESOURCE_PATH + "\\Output.txt"))) {
            writer.write(Double.toString(size));
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static void traverse(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File nextFile : files) {
                    traverse(nextFile);
                }
            }
        }
        if (file.isFile()) {
            size += (double) file.length() / TO_MEGABYTES;
        }
    }
}