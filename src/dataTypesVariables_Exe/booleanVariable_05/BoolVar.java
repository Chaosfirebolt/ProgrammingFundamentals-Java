package dataTypesVariables_Exe.booleanVariable_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class BoolVar {

    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        boolean bool = Boolean.parseBoolean(input);
        System.out.println(bool ? "Yes" : "No");
    }
}