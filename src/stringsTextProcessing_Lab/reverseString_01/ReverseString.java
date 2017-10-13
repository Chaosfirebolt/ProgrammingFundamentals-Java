package stringsTextProcessing_Lab.reverseString_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 12.10.2017 г.
 */
public class ReverseString {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        reader.close();
        System.out.println(reverse(string));
    }

    private static String reverse(String string) {
        StringBuilder output = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            output.append(string.charAt(i));
        }
        return output.toString();
    }
}