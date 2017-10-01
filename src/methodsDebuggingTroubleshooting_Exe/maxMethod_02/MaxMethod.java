package methodsDebuggingTroubleshooting_Exe.maxMethod_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class MaxMethod {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();

        int max = getMax(a, b);
        max = getMax(max, c);
        System.out.println(max);
    }

    private static int getMax(int a, int b) {
        return a >= b ? a : b;
    }
}