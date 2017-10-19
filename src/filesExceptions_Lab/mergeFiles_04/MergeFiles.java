package filesExceptions_Lab.mergeFiles_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ChaosFire on 19.10.2017 г.
 */
public class MergeFiles {

    private static final String RESOURCE_PATH = "\\resources\\04. Merge Files";

    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        List<String> lines = new ArrayList<>();
        readFile(lines, projectDir + RESOURCE_PATH + "\\FileOne.txt");
        readFile(lines, projectDir + RESOURCE_PATH + "\\FileTwo.txt");
        lines.sort(Comparator.naturalOrder());
        StringBuilder output = new StringBuilder();
        for (String line : lines) {
            output.append(line).append(System.lineSeparator());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + RESOURCE_PATH + "\\Output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static void readFile(List<String> lines, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}