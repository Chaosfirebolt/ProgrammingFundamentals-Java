package filesExceptions_Exe.equalSums_03;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class ES {

    private static final String RES_DIR = "\\resources_Exe\\03_ES";

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
            int[] numbers = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] leftSums = new int[numbers.length];
            int[] rightSums = new int[numbers.length];
            calSums(numbers, leftSums, rightSums);
            int index = findIndex(leftSums, rightSums);
            output.append(index == -1 ? "no" : index).append(System.lineSeparator());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static int findIndex(int[] leftSums, int[] rightSums) {
        for (int i = 0; i < leftSums.length; i++) {
            if (leftSums[i] != rightSums[i]) {
                continue;
            }
            return i;
        }
        return -1;
    }

    private static void calSums(int[] numbers, int[] leftSums, int[] rightSums) {
        for (int i = 1; i < numbers.length; i++) {
            leftSums[i] = leftSums[i - 1] + numbers[i - 1];
            int rightSumsIndex = numbers.length - i;
            rightSums[numbers.length - 1 - i] = rightSums[rightSumsIndex] + numbers[rightSumsIndex];
        }
    }
}