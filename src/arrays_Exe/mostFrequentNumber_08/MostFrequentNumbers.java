package arrays_Exe.mostFrequentNumber_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 3.10.2017 г.
 */
public class MostFrequentNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();

        Map<Integer, Integer> freqCount = new LinkedHashMap<>();
        for (int number : numbers) {
            Integer count = freqCount.get(number);
            if (count == null) {
                freqCount.put(number, 1);
            } else {
                freqCount.replace(number, count + 1);
            }
        }

        int result = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (entry.getValue() > count) {
                result = entry.getKey();
                count = entry.getValue();
            }
        }
        System.out.println(result);
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}