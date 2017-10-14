package stringsTextProcessing_Exe.magicExchangeable_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class MagicExchangeableWords {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = parseInput(reader.readLine());
        reader.close();

        boolean areExchangeable = areExchangeable(input[0], input[1]);
        System.out.println(areExchangeable);
    }

    private static boolean areExchangeable(String first, String second) {
        Map<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char keyChar = first.charAt(i);
            char valueChar;
            try {
                valueChar = second.charAt(i);
            }
            catch (IndexOutOfBoundsException exc) {
                if (!mapping.containsKey(keyChar)) {
                    return false;
                }
                continue;
            }

            if (!mapping.containsKey(keyChar)) {
                mapping.put(keyChar, valueChar);
                continue;
            }
            if (valueChar != mapping.get(keyChar)) {
                return false;
            }
        }
        return true;
    }

    private static String[] parseInput(String input) {
        String[] words = input.split("\\s+");
        if (words[0].length() < words[1].length()) {
            String temp = words[0];
            words[0] = words[1];
            words[1] = temp;
        }
        return words;
    }
}