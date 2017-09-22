package conditionalStatementsLoops_Exe.fiveDifferentNumbers_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class DifferentNumbers {

    private static StringBuilder output = new StringBuilder();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();
        if (b - a < 4) {
            System.out.println("No");
        } else {
            gen(a, b);
            System.out.print(output);
        }
    }

    private static void gen(int a, int b) {
        if (list.size() == 5) {
            output.append(String.join(" ", list)).append(System.lineSeparator());
            return;
        }
        for (int i = a; i <= b; i++) {
            if (b - i < 4 - list.size()) {
                return;
            }
            if (list.size() > 0 && Integer.parseInt(list.get(list.size() - 1)) >= i) {
                continue;
            }
            list.add(Integer.toString(i));
            gen(a + 1, b);
            list.remove(list.size() - 1);
        }
    }
}