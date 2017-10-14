package stringsTextProcessing_Exe.characterMultiplier_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class CharacterMultiplier {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        reader.close();
        System.out.println(sum(input[0], input[1]));
    }

    private static int sum(String word1, String word2) {
        int sum = 0;
        int lowBind = Math.min(word1.length(), word2.length());
        int highBind = Math.max(word1.length(), word2.length());
        for (int i = 0; i < lowBind; i++) {
            sum += word1.charAt(i) * word2.charAt(i);
        }
        String longer = getLonger(word1, word2);
        for (int i = lowBind; i < highBind; i++) {
            sum += longer.charAt(i);
        }
        return sum;
    }

    private static String getLonger(String word1, String word2) {
        return word1.length() >= word2.length() ? word1 : word2;
    }
}