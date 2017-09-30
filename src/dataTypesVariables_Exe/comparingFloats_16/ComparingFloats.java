package dataTypesVariables_Exe.comparingFloats_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class ComparingFloats {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double first = Double.parseDouble(reader.readLine());
        double second = Double.parseDouble(reader.readLine());
        reader.close();

        final double eps = 0.000001;
        double diff = Math.abs(first - second);
        boolean areEqual = diff < eps;
        System.out.println(areEqual ? "True" : "False");
    }
}