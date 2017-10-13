package stringsTextProcessing_Lab.textFilter_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class TextFilter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] banned = reader.readLine().split(",\\s+");
        String text = reader.readLine();
        reader.close();

        for (String bannedWord : banned) {
            String replacement = replacement(bannedWord);
            text = text.replace(bannedWord, replacement);
        }
        System.out.println(text);
    }

    private static String replacement(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}