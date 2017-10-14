package stringsTextProcessing_Exe.convertToBase_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class ConvertToBase {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] data = parseInput(reader.readLine().split("\\s+"));
        BigInteger toBase = data[0];
        BigInteger number = data[1];
        String converted = convert(toBase, number);
        System.out.println(converted);
    }

    private static String convert(BigInteger toBase, BigInteger number) {
        Stack<String> args = new Stack<>();
        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] data = number.divideAndRemainder(toBase);
            number = data[0];
            args.push(data[1].toString());
        }
        StringBuilder result = new StringBuilder();
        while (args.size() > 0) {
            result.append(args.pop());
        }
        return result.toString();
    }

    private static BigInteger[] parseInput(String[] input) {
        BigInteger[] result = new BigInteger[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = new BigInteger(input[i]);
        }
        return result;
    }
}