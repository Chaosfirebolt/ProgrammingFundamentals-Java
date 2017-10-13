package stringsTextProcessing_Lab.countSubstrOccur_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 12.10.2017 г.
 */
public class CountOccurrences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String string = reader.readLine();
        reader.close();
        System.out.println(countOccurrences(text.toLowerCase(), string.toLowerCase()));
    }

    private static int countOccurrences(String text, String string) {
        int count = 0;
        for (int i = 0; i <= text.length() - string.length(); i++) {
            if (text.substring(i, i + string.length()).equalsIgnoreCase(string)) {
                count++;
            }
        }
        return count;
    }
}