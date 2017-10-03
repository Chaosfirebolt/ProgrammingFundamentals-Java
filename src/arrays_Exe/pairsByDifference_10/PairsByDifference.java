package arrays_Exe.pairsByDifference_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 3.10.2017 г.
 */
public class PairsByDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        int diff = Integer.parseInt(reader.readLine());
        reader.close();

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (Math.abs(numbers[i] - numbers[j]) == diff) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}