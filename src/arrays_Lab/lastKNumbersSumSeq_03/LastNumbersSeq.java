package arrays_Lab.lastKNumbersSumSeq_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class LastNumbersSeq {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int prevCount = Integer.parseInt(reader.readLine());
        reader.close();

        long[] array = new long[size];
        array[0] = 1;
        for (int i = 1; i < size; i++) {
            int startIndex = Math.max(0, i - prevCount);
            array[i] = getNext(array, startIndex, i);
        }
        StringBuilder output = new StringBuilder();
        for (long num : array) {
            output.append(num).append(" ");
        }
        System.out.print(output);
    }

    private static long getNext(long[] array, int startIndex, int endIndex) {
        long sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}