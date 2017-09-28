package dataTypesVariables_Lab.greeting_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class Greeting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String lastName = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.printf("Hello, %s %s. You are %d years old.", firstName, lastName, age);
    }
}