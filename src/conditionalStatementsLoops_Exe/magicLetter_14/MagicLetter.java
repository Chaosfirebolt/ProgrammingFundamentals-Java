package conditionalStatementsLoops_Exe.magicLetter_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 22.9.2017 г.
 */
public class MagicLetter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = reader.readLine().charAt(0);
        int last = reader.readLine().charAt(0);
        int excluded = reader.readLine().charAt(0);
        reader.close();

        StringBuilder output = new StringBuilder();
        for (int i = first; i <= last; i++) {
            if (i == excluded) {
                continue;
            }
            for (int j = first; j <= last; j++) {
                if (j == excluded) {
                    continue;
                }
                for (int k = first; k <= last; k++) {
                    if (k == excluded) {
                        continue;
                    }
                    output.append((char) i).append((char) j).append((char) k).append(" ");
                }
            }
        }
        System.out.println(output);
    }
}