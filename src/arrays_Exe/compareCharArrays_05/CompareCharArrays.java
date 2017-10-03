package arrays_Exe.compareCharArrays_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class CompareCharArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split("\\s+");
        String[] second = reader.readLine().split("\\s+");
        reader.close();
        int cmp = compare(first, second);
        if (cmp <= 0) {
            printResult(first, second);
        } else {
            printResult(second, first);
        }
    }

    private static void printResult(String[] arr1, String[] arr2) {
        printArray(arr1);
        printArray(arr2);
    }

    private static void printArray(String[] array) {
        StringBuilder output = new StringBuilder();
        for (String str : array) {
            output.append(str);
        }
        System.out.println(output);
    }

    private static int compare(String[] arr1, String[]arr2) {
        int boundary = Math.min(arr1.length, arr2.length);
        for (int i = 0; i < boundary; i++) {
            int cmp = arr1[i].compareTo(arr2[i]);
            if (cmp != 0) {
                return cmp;
            }
        }
        int lengthDiff = arr1.length - arr2.length;
        if (lengthDiff == 0) {
            return 0;
        }
        return lengthDiff < 0 ? -1 : 1;
    }
}