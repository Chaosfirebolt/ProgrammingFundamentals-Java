package conditionalStatementsLoops_Exe.triangleOfNumbers_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class NumberTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                output.append(i).append(" ");
            }
            output.append(System.lineSeparator());
        }
        System.out.println(output);
    }
}