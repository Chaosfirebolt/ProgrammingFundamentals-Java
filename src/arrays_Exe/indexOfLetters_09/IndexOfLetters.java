package arrays_Exe.indexOfLetters_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 3.10.2017 г.
 */
public class IndexOfLetters {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        reader.close();

        final int offset = 97;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            output.append(String.format("%c -> %d", word.charAt(i), word.charAt(i) - offset)).append(System.lineSeparator());
        }
        System.out.println(output);
    }
}