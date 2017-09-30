package dataTypesVariables_Exe.intToHexAndBinary_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class IntToHexBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(Integer.toHexString(decimal).toUpperCase());
        System.out.println(Integer.toBinaryString(decimal).toUpperCase());
    }
}