package arrays_Lab.reverseArrayOfStrings_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class ReverseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        reader.close();
        reverseArray(array);
        System.out.println(String.join(" ", array));
    }

    private static void reverseArray(String[] array) {
        int bound = array.length / 2;
        int lastIndex = array.length - 1;
        for (int i = 0; i < bound; i++) {
            swap(array, i, lastIndex - i);
        }
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}