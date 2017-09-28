package dataTypesVariables_Lab.refactorSpecialNumbers_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class RefactorSpecialNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lastNum = Integer.parseInt(reader.readLine());
        reader.close();

        for (int i = 1; i <= lastNum; i++)
        {
            int current = i;
            int sum = 0;
            while (current > 0)
            {
                sum += current % 10;
                current /= 10;
            }
            boolean isSpecial = sum == 5 || sum == 7 || sum == 11;
            System.out.printf("%d -> %s\n", i, isSpecial);
        }
    }
}