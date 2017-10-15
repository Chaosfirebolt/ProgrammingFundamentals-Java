package regEx_Exe.extractSentences_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class ExtractSentences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        String text = reader.readLine();
        reader.close();
        String output = extract(text, key);
        System.out.print(output);
    }

    private static String extract(String text, String key) {
        StringBuilder result = new StringBuilder();
        String[] sentences = text.split("[.!?]\\s*");
        String extractionRegex = String.format("\\b%s\\b", key);
        Pattern pattern = Pattern.compile(extractionRegex);
        for (String sentence : sentences) {
            if (pattern.matcher(sentence).find()) {
                result.append(sentence).append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}