package methodsDebuggingTroubleshooting_Lab.mathPower_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class MathPower {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.parseDouble(reader.readLine());
        int power = Integer.parseInt(reader.readLine());
        reader.close();
        DecimalFormat format = new DecimalFormat("0.############");
        System.out.print(format.format(power(num, power)));
    }

    private static double power(double num, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
}