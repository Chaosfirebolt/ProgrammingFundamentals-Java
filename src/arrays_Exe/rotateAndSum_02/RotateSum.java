package arrays_Exe.rotateAndSum_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class RotateSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        int rotations = Integer.parseInt(reader.readLine());
        int[] sums = new int[numbers.length];
        for (int i = 0; i < rotations; i++) {
            rotateArray(numbers);
            sumArrays(sums, numbers);
        }
        print(sums);
    }

    private static void print(int[] sums) {
        StringBuilder output = new StringBuilder();
        output.append(sums[0]);
        for (int i = 1; i < sums.length; i++) {
            output.append(" ").append(sums[i]);
        }
        System.out.print(output);
    }

    private static void sumArrays(int[] sums, int[] numbers) {
        for (int i = 0; i < sums.length; i++) {
            sums[i] += numbers[i];
        }
    }

    @SuppressWarnings("ManualArrayCopy")
    private static void rotateArray(int[] numbers) {
        int temp = numbers[numbers.length - 1];
        for (int i = numbers.length - 2; i >= 0; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[0] = temp;
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}