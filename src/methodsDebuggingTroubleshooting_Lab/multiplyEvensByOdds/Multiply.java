package methodsDebuggingTroubleshooting_Lab.multiplyEvensByOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class Multiply {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        reader.close();
        System.out.println(calcResult(number));
    }

    private static int calcResult(String number) {
        int sumEvens = 0;
        int sumOdds = 0;
        int startIndex = number.startsWith("-") ? 1 : 0;
        for (int i = startIndex; i < number.length(); i++) {
            int num = Integer.parseInt(Character.toString(number.charAt(i)));
            if (num % 2 == 0) {
                sumEvens += num;
            } else {
                sumOdds += num;
            }
        }
        return sumEvens * sumOdds;
    }
}