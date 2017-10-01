package methodsDebuggingTroubleshooting_Exe.fibonacciNumbers_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class FibonacciNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}