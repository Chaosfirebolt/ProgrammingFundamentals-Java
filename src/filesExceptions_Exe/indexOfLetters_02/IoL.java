package filesExceptions_Exe.indexOfLetters_02;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class IoL {

    private static final String RES_DIR = "\\resources_Exe\\02_IoL";

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
            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);
                output.append(String.format("%c -> %d", character, character - 97)).append(System.lineSeparator());
            }
            output.append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}