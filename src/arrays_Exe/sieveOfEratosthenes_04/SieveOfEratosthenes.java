package arrays_Exe.sieveOfEratosthenes_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();

        boolean[] array = initialize(number);
        findPrimes(array, number);
        print(array);
    }

    private static void print(boolean[] array) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                output.append(i).append(" ");
            }
        }
        System.out.println(output);
    }

    private static void findPrimes(boolean[] array, int number) {
        int boundary = (int) Math.ceil(Math.sqrt(number));
        for (int i = 2; i <= boundary; i++) {
            if (array[i]) {
                for (int j = i * i; j <= number; j += i) {
                    array[j] = false;
                }
            }
        }
    }

    private static boolean[] initialize(int number) {
        boolean[] array = new boolean[number + 1];
        for (int i = 2; i < array.length; i++) {
            array[i] = true;
        }
        return array;
    }
}