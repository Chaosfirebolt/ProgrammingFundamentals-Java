package methodsDebuggingTroubleshooting_Exe.masterNumbers_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class MasterNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int boundary = Integer.parseInt(reader.readLine());
        reader.close();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= boundary; i++) {
            if (isPalindrome(i) && isSumDigitsDivisible(i) && hasEvenDigit(i)) {
                output.append(i).append(System.lineSeparator());
            }
        }
        System.out.print(output);
    }

    private static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int loopBound = str.length() / 2;
        for (int i = 0; i < loopBound; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isSumDigitsDivisible(int number) {
        int sum = 0;
        String str = Integer.toString(number);
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(Character.toString(str.charAt(i)));
        }
        return sum % 7 == 0;
    }

    private static boolean hasEvenDigit(int number) {
        String str = Integer.toString(number);
        for (int i = 0; i < str.length(); i++) {
            if (Integer.parseInt(Character.toString(str.charAt(i))) % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}