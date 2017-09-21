package conditionalStatementsLoops_Lab.passed_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class Passed {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double grade = Double.parseDouble(reader.readLine());
        reader.close();
        if (grade >= 3) {
            System.out.println("Passed!");
        }
    }
}