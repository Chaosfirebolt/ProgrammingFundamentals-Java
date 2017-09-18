package basicSyntax_Lab.addTwoNumbers_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 18.9.2017 г.
 */
public class AddNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.printf("%d + %d = %d", a, b, a + b);
    }
}