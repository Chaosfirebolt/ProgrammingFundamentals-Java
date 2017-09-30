package methodsDebuggingTroubleshooting_Lab.drawFilledSquare_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class DrawFilledSquare {

    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        printSquare(num);
    }

    private static void printSquare(int num) {
        int length = num * 2;
        printEndLine(length);
        for (int i = 0; i < num - 2; i++) {
            printBody(length);
        }
        printEndLine(length);
        System.out.print(output);
    }

    private static void printBody(int length) {
        output.append('-');
        for (int i = 1; i < length - 1; i++) {
            output.append(i % 2 == 0 ? '/' : '\\');
        }
        output.append('-').append(System.lineSeparator());
    }

    private static void printEndLine(int length) {
        for (int i = 0; i < length; i++) {
            output.append('-');
        }
        output.append(System.lineSeparator());
    }
}