package basicSyntax_Exe.debitCardNumber_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 19.9.2017 г.
 */
public class DebitCard {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            output.append(padLeft(input)).append(" ");
        }
        reader.close();
        System.out.println(output.toString().trim());
    }

    private static String padLeft(String string) {
        StringBuilder result = new StringBuilder();
        int count = 4 - string.length();
        for (int i = 0; i < count; i++) {
            result.append("0");
        }
        result.append(string);
        return result.toString();
    }
}