package dataTypesVariables_Exe.reverseCharacters_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class ReverseChars {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int count = 3;
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = reader.readLine().charAt(0);
        }
        for (int i = 2; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}