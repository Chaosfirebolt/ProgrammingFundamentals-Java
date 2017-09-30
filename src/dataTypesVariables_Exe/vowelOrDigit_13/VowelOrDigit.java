package dataTypesVariables_Exe.vowelOrDigit_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class VowelOrDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char character = reader.readLine().charAt(0);
        reader.close();
        if (Character.isDigit(character)) {
            System.out.println("digit");
        } else if (character == 65 || character == 69 || character == 73 || character == 79 || character == 85 || character == 89 ||
                character == 97 || character == 101 || character == 105 || character == 111 || character == 117 || character == 121) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}