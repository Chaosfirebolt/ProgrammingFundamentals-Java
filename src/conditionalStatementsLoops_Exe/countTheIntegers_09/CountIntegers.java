package conditionalStatementsLoops_Exe.countTheIntegers_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class CountIntegers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            try {
                Integer.parseInt(reader.readLine());
                count++;
            } catch (NumberFormatException exc) {
                System.out.println(count);
                break;
            }
        }
        reader.close();
    }
}