package conditionalStatementsLoops_Exe.gameOfNumbers_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 22.9.2017 г.
 */
public class GameNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int magicNum = Integer.parseInt(reader.readLine());
        reader.close();

        if (magicNum < n * 2 || magicNum > m * 2) {
            System.out.printf("%.0f combinations - neither equals %d", Math.pow(m - n + 1, 2), magicNum);
        } else {
            int first = magicNum - n;
            if (first > m) {
                first = m;
            }
            int second = magicNum - first;
            System.out.printf("Number found! %d + %d = %d", first, second, magicNum);
        }
    }
}