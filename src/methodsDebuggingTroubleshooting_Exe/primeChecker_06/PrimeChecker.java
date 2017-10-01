package methodsDebuggingTroubleshooting_Exe.primeChecker_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class PrimeChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        reader.close();
        System.out.println(boolString(isPrime(n)));
    }

    private static String boolString(boolean bool) {
        String output = Boolean.toString(bool);
        return output.substring(0, 1).toUpperCase() + output.substring(1);
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int boundary = (int) Math.sqrt(n);
        for (int i = 3; i <= boundary; i += 2) {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}