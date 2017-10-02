package arrays_Lab.tripleSum_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class TripleSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        reader.close();

        int[] numbers = parseInput(input);
        List<String> sums = new LinkedList<>();
        generateCombinations(numbers, sums);
        System.out.println(sums.size() > 0 ? String.join(System.lineSeparator(), sums) : "No");
    }

    private static void generateCombinations(int[] numbers, List<String> sums) {
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                if (containsSum(numbers, a + b)) {
                    sums.add(String.format("%d + %d == %d", a, b, a + b));
                }
            }
        }
    }

    private static boolean containsSum(int[] numbers, int sum) {
        for (int number : numbers) {
            if (number == sum) {
                return true;
            }
        }
        return false;
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}