package dataTypesVariables_Exe.variableInHex_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class VarInHex {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        System.out.println(Integer.parseInt(input.substring(2), 16));
    }
}