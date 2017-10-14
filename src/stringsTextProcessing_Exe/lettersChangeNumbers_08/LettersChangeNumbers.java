package stringsTextProcessing_Exe.lettersChangeNumbers_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class LettersChangeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] operands = reader.readLine().split("\\s+");
        reader.close();

        double result = 0;
        for (String operand : operands) {
            result += processOperand(operand);
        }
        System.out.printf("%.2f", result);
    }

    private static double processOperand(String operand) {
        char firstChar = operand.charAt(0);
        double number = Double.parseDouble(operand.substring(1, operand.length() - 1));
        number = Character.isUpperCase(firstChar) ? number / positionInAlphabet(firstChar) : number * positionInAlphabet(firstChar);
        char lastChar = operand.charAt(operand.length() - 1);
        number = Character.isUpperCase(lastChar) ? number - positionInAlphabet(lastChar) : number + positionInAlphabet(lastChar);
        return number;
    }

    private static int positionInAlphabet(char character) {
        return Character.isUpperCase(character) ? character - 64 : character - 96;
    }
}