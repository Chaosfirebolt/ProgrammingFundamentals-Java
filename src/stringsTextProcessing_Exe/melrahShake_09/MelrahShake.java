package stringsTextProcessing_Exe.melrahShake_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class MelrahShake {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String pattern = reader.readLine();
        reader.close();

        int firstIndex = text.indexOf(pattern);
        int lastIndex = text.lastIndexOf(pattern);
        StringBuilder output = new StringBuilder();
        while (pattern.length() > 0 && firstIndex > -1 && lastIndex > -1 && firstIndex != lastIndex) {
            output.append("Shaked it.").append(System.lineSeparator());
            text = removeFromText(text, firstIndex, lastIndex, pattern.length());
            pattern = updatePattern(pattern);
            firstIndex = text.indexOf(pattern);
            lastIndex = text.lastIndexOf(pattern);
        }
        output.append("No shake.").append(System.lineSeparator()).append(text);
        System.out.print(output);
    }

    private static String removeFromText(String text, int firstIndex, int lastIndex, int length) {
        text = remove(text, lastIndex, length);
        return remove(text, firstIndex, length);
    }

    private static String updatePattern(String pattern) {
        int index = pattern.length() / 2;
        return remove(pattern, index, 1);
    }

    private static String remove(String string, int index, int length) {
        int endIndex = index + length;
        return string.substring(0, index) + string.substring(endIndex);
    }
}