package methodsDebuggingTroubleshooting_Lab.printTriangle_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class PrintTriangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        print(num);
    }

    private static void print(int num) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                output.append(j).append(" ");
            }
            output.append(System.lineSeparator());
        }
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                output.append(j).append(" ");
            }
            output.append(System.lineSeparator());
        }
        System.out.print(output);
    }
}