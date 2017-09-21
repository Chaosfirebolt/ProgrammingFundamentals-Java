package conditionalStatementsLoops_Lab.multiplicationTable_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class MultiplicationTable {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            output.append(String.format("%d X %d = %d", n, i, n * i)).append(System.lineSeparator());
        }
        System.out.println(output);
    }
}