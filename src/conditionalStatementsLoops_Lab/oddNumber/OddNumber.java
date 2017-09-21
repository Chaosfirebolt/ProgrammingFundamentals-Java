package conditionalStatementsLoops_Lab.oddNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class OddNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (input != null) {
            int num = Integer.parseInt(input);
            if (num % 2 == 0) {
                System.out.println("Please write an odd number.");
            } else {
                System.out.printf("The number is: %d\n", Math.abs(num));
            }

            input = reader.readLine();
        }
        reader.close();
    }
}