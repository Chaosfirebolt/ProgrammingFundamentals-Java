package conditionalStatementsLoops_Lab.multiplicationTableTwo_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class MultiplicationTableTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int multiplier = Integer.parseInt(reader.readLine());
        reader.close();
        StringBuilder output = new StringBuilder();
        if (multiplier  > 10) {
            output.append(String.format("%d X %d = %d", n, multiplier, n * multiplier));
        } else {
            for (int i = multiplier; i <= 10; i++) {
                output.append(String.format("%d X %d = %d", n, i, n * i)).append(System.lineSeparator());
            }
        }
        System.out.println(output);
    }
}