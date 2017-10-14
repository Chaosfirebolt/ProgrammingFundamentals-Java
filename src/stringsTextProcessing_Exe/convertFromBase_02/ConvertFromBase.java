package stringsTextProcessing_Exe.convertFromBase_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 13.10.2017 г.
 */
public class ConvertFromBase {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        reader.close();

        BigInteger fromBase = new BigInteger(input[0]);
        String number = input[1];
        BigInteger result = convert(fromBase, number);
        System.out.println(result);
    }

    private static BigInteger convert(BigInteger fromBase, String number) {
        BigInteger result = BigInteger.ZERO;
        for (int i = number.length() - 1; i >= 0; i--) {
            int index = number.length() - 1 - i;
            BigInteger num = new BigInteger(Character.toString(number.charAt(index)));
            BigInteger pow = fromBase.pow(i);
            num = num.multiply(pow);
            result = result.add(num);
        }
        return result;
    }
}