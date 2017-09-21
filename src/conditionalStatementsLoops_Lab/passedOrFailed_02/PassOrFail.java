package conditionalStatementsLoops_Lab.passedOrFailed_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class PassOrFail {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double grade = Double.parseDouble(reader.readLine());
        if(grade >= 3) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}