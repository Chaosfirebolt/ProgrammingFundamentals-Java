package methodsDebuggingTroubleshooting_Exe.factorial_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class Factorial {

    private static Map<BigInteger, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger number = new BigInteger(reader.readLine());
        reader.close();

        initializeMemo();
        BigInteger result = calcFactorial(number);
        System.out.println(result);
    }

    private static void initializeMemo() {
        memo.put(BigInteger.ONE, BigInteger.ONE);
    }

    private static BigInteger calcFactorial(BigInteger number) {
        BigInteger factorial = memo.get(number);
        if (factorial != null) {
            memo.put(number, factorial);
            return factorial;
        }

        factorial = calcFactorial(number.subtract(BigInteger.ONE)).multiply(number);
        memo.put(number, factorial);
        return factorial;
    }
}