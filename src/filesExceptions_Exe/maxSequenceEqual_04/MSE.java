package filesExceptions_Exe.maxSequenceEqual_04;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class MSE {

    private static final String RES_DIR = "\\resources_Exe\\04_MSE";

    public static void main(String[] args) {
        String project = System.getProperty("user.dir");
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            String input = reader.readLine();
            while (input != null) {
                lines.add(input);
                input = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        StringBuilder output = new StringBuilder();
        for (String line : lines) {
            output.append(findSequence(line.split("\\s+"))).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static String findSequence(String[] array) {
        List<String> maxSeq = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (maxSeq.size() >= array.length - i) {
                break;
            }
            List<String> currSeq = new ArrayList<>();
            currSeq.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                if (!array[i].equals(array[j])) {
                    break;
                }
                currSeq.add(array[j]);
            }
            if (currSeq.size() > maxSeq.size()) {
                maxSeq = currSeq;
            }
        }
        return String.join(" ", maxSeq);
    }
}