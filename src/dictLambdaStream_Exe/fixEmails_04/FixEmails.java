package dictLambdaStream_Exe.fixEmails_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class FixEmails {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String input = reader.readLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = reader.readLine();
            if (!email.endsWith("us") && !email.endsWith("us")) {
                output.append(String.format("%s -> %s", name, email)).append(System.lineSeparator());
            }

            input = reader.readLine();
        }
        reader.close();
        System.out.print(output);
    }
}