package filesExceptions_Exe.minerTask_05;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class MT {

    private static final String RES_DIR = "\\resources_Exe\\05_MT";

    public static void main(String[] args) {
        String project = System.getProperty("user.dir");
        Map<String, Long> resources = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            String input = reader.readLine();
            while (!input.equals("stop")) {
                String resource = input;
                long quantity = Long.parseLong(reader.readLine());
                Long currentQuantity = resources.get(resource);
                if (currentQuantity == null) {
                    resources.put(resource, quantity);
                } else {
                    resources.replace(resource, currentQuantity + quantity);
                }

                input = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            output.append(String.format("%s -> %s", entry.getKey(), entry.getValue())).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}