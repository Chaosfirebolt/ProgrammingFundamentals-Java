package lists_Lab.countNumbers_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class CountNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> sortedNumbers = new ArrayList<>();
        Map<Integer, Integer> countNumbers = new HashMap<>();
        processInput(reader.readLine().split("\\s+"), sortedNumbers, countNumbers);
        print(sortedNumbers, countNumbers);
    }

    private static void print(List<Integer> sortedNumbers, Map<Integer, Integer> countNumbers) {
        StringBuilder output = new StringBuilder();
        for (Integer number : sortedNumbers) {
            output.append(String.format("%d -> %d", number, countNumbers.get(number))).append(System.lineSeparator());
        }
        System.out.print(output);
    }

    private static void processInput(String[] input, List<Integer> sortedNumbers, Map<Integer, Integer> countNumbers) {
        for (String str : input) {
            int number = Integer.parseInt(str);
            Integer count = countNumbers.get(number);
            if (count == null) {
                countNumbers.put(number, 1);
                sortedNumbers.add(number);
            } else {
                countNumbers.replace(number, count + 1);
            }
        }
        sortedNumbers.sort(Comparator.naturalOrder());
    }
}