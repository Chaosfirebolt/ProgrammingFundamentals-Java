package methodsDebuggingTroubleshooting_Exe.primesInRange_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class PrimesRange {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());
        reader.close();
        List<String> primes = getPrimesInRange(start, end);
        System.out.println(String.join(", ", primes));
    }

    private static List<String> getPrimesInRange(int start, int end) {
        List<String> result = new ArrayList<>();
        if (2 >= start && 2 <= end) {
            result.add("2");
        }
        if (start % 2 == 0) {
            start++;
        }
        for (int number = start; number <= end; number += 2) {
            if (isPrime(number)) {
                result.add(Integer.toString(number));
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        switch (n) {
            case 0:
            case 1:
                return false;
            case 2:
            case 3:
                return true;
            default:
                if (n % 2 == 0) {
                    return false;
                }
                int boundary = (int) Math.sqrt(n);
                for (int i = 3; i <= boundary; i += 2) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
        }
    }
}