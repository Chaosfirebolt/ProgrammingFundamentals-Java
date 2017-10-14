package stringsTextProcessing_Exe.unicodeCharacters_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class UnicodeCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        reader.close();
        System.out.println(convert(text));
    }

    private static String convert(String text) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            output.append(String.format("\\u%04x", (int) text.charAt(i)));
        }
        return output.toString();
    }
}