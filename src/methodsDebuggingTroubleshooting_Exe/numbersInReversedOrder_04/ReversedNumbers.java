package methodsDebuggingTroubleshooting_Exe.numbersInReversedOrder_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class ReversedNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        reader.close();
        printReversed(num);
    }

    private static void printReversed(String num) {
        StringBuilder output = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            output.append(num.charAt(i));
        }
        System.out.println(output);
    }
}