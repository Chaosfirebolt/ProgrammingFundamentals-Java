package lists_Lab.splitByWordCasing_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class SplitByCasing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        process(reader.readLine());
        reader.close();
    }

    private static void process(String input) {
        String[] words = input.split("[,;:.!()\"'\\\\/\\[\\] ]");
        List<String> lower = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        List<String> upper = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            addToList(lower, mixed, upper, word);
        }
        System.out.println("Lower-case: " + String.join(", ", lower));
        System.out.println("Mixed-case: " + String.join(", ", mixed));
        System.out.println("Upper-case: " + String.join(", ", upper));
    }

    private static void addToList(List<String> lower, List<String> mixed, List<String> upper, String word) {
        int lowerCount = 0;
        int upperCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                lowerCount++;
            } else if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }
        if (lowerCount == word.length()) {
            lower.add(word);
            return;
        }
        if (upperCount == word.length()) {
            upper.add(word);
            return;
        }
        mixed.add(word);
    }
}