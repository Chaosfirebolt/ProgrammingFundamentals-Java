package arrays_Lab.extractMiddleElements_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class ExtractMiddle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        reader.close();
        if (array.length == 1) {
            print(array);
            return;
        }
        String[] result = array.length % 2 == 0 ? getMiddle(array, 2) : getMiddle(array, 3);
        print(result);
    }

    @SuppressWarnings("ManualArrayCopy")
    private static String[] getMiddle(String[] array, int count) {
        String[] result = new String[count];
        for (int i = -1; i < count - 1; i++) {
            result[i + 1] = array[array.length / 2 + i];
        }
        return result;
    }

    private static void print(String[] array) {
        System.out.printf("{ %s }", String.join(", ", array));
    }
}