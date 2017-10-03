package arrays_Exe.maxSequenceOfEqualElements_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class MaxSequenceEqual {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        reader.close();
        String sequence = findSequence(array);
        System.out.println(sequence);
    }

    private static String findSequence(String[] array) {
        List<String> maxSeq = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (maxSeq.size() >= array.length - i) {
                break;
            }
            List<String> currSeq = new ArrayList<>();
            currSeq.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                if (!array[i].equals(array[j])) {
                    break;
                }
                currSeq.add(array[j]);
            }
            if (currSeq.size() > maxSeq.size()) {
                maxSeq = currSeq;
            }
        }
        return String.join(" ", maxSeq);
    }
}