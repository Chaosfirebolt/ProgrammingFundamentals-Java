package arrays_Exe.equalSums_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 3.10.2017 г.
 */
public class EqualsSums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();

        int[] leftSums = new int[numbers.length];
        int[] rightSums = new int[numbers.length];
        calSums(numbers, leftSums, rightSums);
        int index = findIndex(leftSums, rightSums);
        System.out.println(index == -1 ? "no" : index);
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

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}