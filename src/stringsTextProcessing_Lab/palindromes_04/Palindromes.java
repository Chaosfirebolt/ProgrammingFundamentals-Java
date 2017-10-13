package stringsTextProcessing_Lab.palindromes_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class Palindromes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = parseInput(reader.readLine());
        reader.close();

        Set<String> palindromes = new HashSet<>();
        for (String word : words) {
            if (!word.isEmpty() && isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        System.out.print(String.join(", ", palindromes.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList())));
    }

    private static boolean isPalindrome(String word) {
        int bound = word.length() / 2;
        for (int i = 0; i < bound; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static String[] parseInput(String input) {
        return input.split("[\\s+,.?!]");
    }
}