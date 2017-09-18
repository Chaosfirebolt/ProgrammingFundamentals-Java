package basicSyntax_Lab.greeting_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 18.9.2017 г.
 */
public class Greeting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Hello, %s!", reader.readLine());
        reader.close();
    }
}