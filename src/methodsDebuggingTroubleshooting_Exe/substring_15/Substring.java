package methodsDebuggingTroubleshooting_Exe.substring_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class Substring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int jump = Integer.parseInt(reader.readLine());
        reader.close();

        final char search = 'p';
        boolean hasMatch = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == search) {
                hasMatch = true;
                int endIndex = Math.min(i + jump + 1, text.length());
                String matchedString = text.substring(i, endIndex);
                System.out.println(matchedString);
                i += jump;
            }
        }
        if (!hasMatch) {
            System.out.println("no");
        }
    }
}