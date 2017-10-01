package methodsDebuggingTroubleshooting_Exe.factorialTrailingZeroes_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();
        int countZeroes = calcTrailingZeroes(number);
        System.out.println(countZeroes);
    }

    private static int calcTrailingZeroes(int number) {
        int count = 0;
        int power = 1;
        int powerOfFive = calcPowFive(power);
        while (powerOfFive <= number) {
            count += number / powerOfFive;
            powerOfFive = calcPowFive(++power);
        }
        return count;
    }

    private static int calcPowFive(int power) {
        return (int) Math.pow(5, power);
    }
}