package arrays_Lab.roundAwayFromZero_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class RoundAwayFromZero {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        reader.close();

        double[] numbers = parseInput(input);
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            if (number > 0) {
                System.out.printf("%s => %.0f%s", input[i], roundAwayFromZero(number), System.lineSeparator());
            } else {
                System.out.printf("%s => %.0f%s", input[i], roundAwayFromZero(number), System.lineSeparator());
            }
        }
    }

    private static double roundAwayFromZero(double number) {
        double remainder = Math.abs(number % 1);
        if (number > 0) {
            if (remainder >= 0.5) {
                return Math.ceil(number);
            } else {
                return Math.floor(number);
            }
        } else if (number < 0) {
            if (remainder >= 0.5) {
                return Math.floor(number);
            } else {
                return Math.ceil(number);
            }
        } else {
            return 0;
        }
    }

    private static double[] parseInput(String[] input) {
        double[] result = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Double.parseDouble(input[i]);
        }
        return result;
    }
}