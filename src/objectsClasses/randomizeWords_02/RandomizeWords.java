package objectsClasses.randomizeWords_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by ChaosFire on 9.10.2017 г.
 */
public class RandomizeWords {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");
        reader.close();

        randomize(words);
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(word).append(System.lineSeparator());
        }
        System.out.print(output);
    }

    private static void randomize(String[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i);
            swap(array, i, j);
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}