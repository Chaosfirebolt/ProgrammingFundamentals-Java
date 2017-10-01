package methodsDebuggingTroubleshooting_Exe.bePositive_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class BePositive {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int seqCount = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < seqCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            List<Integer> numbers = new LinkedList<>();
            for (String str : input) {
                if (!str.equals("")) {
                    numbers.add(Integer.parseInt(str));
                }
            }
            int last = Integer.MIN_VALUE;
            boolean hasPositive = false;
            for (int number : numbers) {
                if (last != Integer.MIN_VALUE) {
                    int sum = last + number;
                    if (sum >= 0) {
                        output.append(sum).append(" ");
                        hasPositive = true;
                    }
                    last = Integer.MIN_VALUE;
                }
                else {
                    if (number < 0) {
                        last = number;
                    }
                    else {
                        output.append(number).append(" ");
                        hasPositive = true;
                    }
                }
            }
            if (!hasPositive) {
                output.append("(empty)");
            }
            output.append(System.lineSeparator());
        }
        System.out.print(output);
    }
}