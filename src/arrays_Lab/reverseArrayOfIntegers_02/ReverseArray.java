package arrays_Lab.reverseArrayOfIntegers_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class ReverseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[] array = new String[size];
        for (int i = size - 1; i >= 0; i--) {
            array[i] = reader.readLine();
        }
        System.out.println(String.join(" ", array));
    }
}