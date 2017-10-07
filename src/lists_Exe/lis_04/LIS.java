package lists_Exe.lis_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ChaosFire on 6.10.2017 г.
 */
public class LIS {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        List<String> lis = calcLIS(numbers);
        System.out.print(String.join(" ", lis));
    }

    private static List<String> calcLIS(int[] sequence) {
        int[] length = new int[sequence.length];
        int[] previous = new int[sequence.length];
        int maxLength = 0;
        int lastIndex = -1;
        for (int x = 0; x < sequence.length; x++) {
            length[x] = 1;
            previous[x] = -1;
            for (int i = 0; i <= x - 1; i++) {
                if (sequence[i] < sequence[x] && length[i] + 1 > length[x]) {
                    length[x] = length[i] + 1;
                    previous[x] = i;
                }
            }
            if (length[x] > maxLength) {
                maxLength = length[x];
                lastIndex = x;
            }
        }
        return restoreLIS(sequence, previous, lastIndex);
    }

    private static List<String> restoreLIS(int[] sequence, int[] previous, int lastIndex) {
        List<String> longestSeq = new ArrayList<>();
        while (lastIndex != -1) {
            longestSeq.add(Integer.toString(sequence[lastIndex]));
            lastIndex = previous[lastIndex];
        }
        Collections.reverse(longestSeq);
        return longestSeq;
    }

    private static int[] parseInput(String[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}