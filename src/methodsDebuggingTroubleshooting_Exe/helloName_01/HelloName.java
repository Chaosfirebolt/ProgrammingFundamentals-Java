package methodsDebuggingTroubleshooting_Exe.helloName_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class HelloName {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        greet(name);
    }

    private static void greet(String name) {
        System.out.printf("Hello, %s!", name);
    }
}