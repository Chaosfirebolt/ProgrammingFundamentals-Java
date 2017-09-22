package conditionalStatementsLoops_Exe.testNumbers_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 22.9.2017 г.
 */
public class TestNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int boundary = Integer.parseInt(reader.readLine());
        reader.close();

        int sum = 0;
        int count = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                sum += 3 * i * j;
                count++;
                if (sum >= boundary) {
                    System.out.printf("%d combinations\n", count);
                    System.out.printf("Sum: %d >= %d", sum, boundary);
                    return;
                }
            }
        }
        System.out.printf("%d combinations\n", count);
        System.out.printf("Sum: %d", sum);
    }
}