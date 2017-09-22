package conditionalStatementsLoops_Exe.intervalOfNumbers_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class IntervalNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());
        reader.close();
        int temp = start;
        start = Math.min(start, end);
        end = Math.max(temp, end);
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}