package filesExceptions_Exe.mostFrequentNumber_01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class MFN {

    private static final String RES_DIR = "\\resources_Exe\\01_MFN";

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
            List<Integer> numbers = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            Map<Integer, Integer> numCount = new LinkedHashMap<>();
            for (Integer number : numbers) {
                Integer count = numCount.get(number);
                if (count == null) {
                    numCount.put(number, 0);
                } else {
                    numCount.replace(number, count + 1);
                }
            }
            int num = 0;
            int count = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
                if (entry.getValue() > count) {
                    count = entry.getValue();
                    num = entry.getKey();
                }
            }
            output.append(num).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}