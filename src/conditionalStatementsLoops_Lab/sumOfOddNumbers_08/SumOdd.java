package conditionalStatementsLoops_Lab.sumOfOddNumbers_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class SumOdd {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        int sum = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < n * 2; i += 2) {
            output.append(i).append(System.lineSeparator());
            sum += i;
        }
        output.append("Sum: ").append(sum);
        System.out.println(output);
    }
}