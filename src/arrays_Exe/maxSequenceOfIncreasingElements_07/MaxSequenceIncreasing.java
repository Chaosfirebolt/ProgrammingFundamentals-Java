package arrays_Exe.maxSequenceOfIncreasingElements_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class MaxSequenceIncreasing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        String sequence = findSequence(array);
        System.out.println(sequence);
    }

    private static String findSequence(int[] array) {
        List<Integer> maxSeq = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (maxSeq.size() >= array.length - i) {
                break;
            }
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= currSeq.get(currSeq.size() - 1)) {
                    break;
                }
                currSeq.add(array[j]);
            }
            if (currSeq.size() > maxSeq.size()) {
                maxSeq = currSeq;
            }
        }
        return printList(maxSeq);
    }

    private static String printList(List<Integer> list) {
        StringBuilder output = new StringBuilder();
        for (Integer number : list) {
            output.append(number).append(" ");
        }
        return output.toString().trim();
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}