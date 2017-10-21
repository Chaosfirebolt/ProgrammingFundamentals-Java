package filesExceptions_Exe.fixEmails_06;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class FE {

    private static final String RES_DIR = "\\resources_Exe\\06_FE";

    public static void main(String[] args) {
        String project = System.getProperty("user.dir");
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            String input = reader.readLine();
            while (!input.equals("stop")) {
                String name = input;
                String email = reader.readLine().toLowerCase();
                if (!email.endsWith("us") && !email.endsWith("us")) {
                    output.append(String.format("%s -> %s", name, email)).append(System.lineSeparator());
                }

                input = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}