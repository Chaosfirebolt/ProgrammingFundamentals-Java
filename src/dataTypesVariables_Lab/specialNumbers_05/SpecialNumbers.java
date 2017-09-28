package dataTypesVariables_Lab.specialNumbers_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class SpecialNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        reader.close();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;
            output.append(String.format("%d -> %s", i, isSpecial)).append(System.lineSeparator());
        }
        System.out.print(output);
    }
}