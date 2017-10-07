package lists_Exe.maxSequenceEqualElements_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class MaxSeqEqual {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        findSequence(numbers);
    }

    private static void findSequence(int[] numbers) {
        int maxNumber = 0;
        int maxCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            int currCount = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] != numbers[j]) {
                    break;
                }
                currCount++;
            }
            if (currCount > maxCount) {
                maxNumber = numbers[i];
                maxCount = currCount;
            }
        }
        print(maxNumber, maxCount);
    }

    private static void print(int maxNumber, int maxCount) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < maxCount; i++) {
            output.append(maxNumber).append(" ");
        }
        System.out.print(output);
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}