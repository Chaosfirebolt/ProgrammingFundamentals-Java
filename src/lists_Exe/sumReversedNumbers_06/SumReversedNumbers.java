package lists_Exe.sumReversedNumbers_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class SumReversedNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = calcSumReversed(reader.readLine().split("\\s+"));
        reader.close();
        System.out.print(sum);
    }

    private static int calcSumReversed(String[] input) {
        int sum = 0;
        for (String number : input) {
            sum += reverseNumber(number);
        }
        return sum;
    }

    private static int reverseNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            sb.append(number.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}