package conditionalStatementsLoops_Exe.wordInPlural_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class Plural {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        reader.close();
        System.out.println(pluralize(word));
    }

    private static String pluralize(String word) {
        if (word.endsWith("y")) {
            return word.substring(0, word.length() - 1) + "ies";
        } else if (word.endsWith("o") || word.endsWith("ch") || word.endsWith("s")
                || word.endsWith("sh") || word.endsWith("x") || word.endsWith("z")) {
            return word + "es";
        } else {
            return word + "s";
        }
    }
}