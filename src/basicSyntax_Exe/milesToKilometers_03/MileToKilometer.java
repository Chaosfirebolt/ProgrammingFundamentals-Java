package basicSyntax_Exe.milesToKilometers_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 19.9.2017 г.
 */
public class MileToKilometer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double miles = Double.parseDouble(reader.readLine());
        reader.close();

        final double conversionRate = 1.60934;
        System.out.printf("%.2f", miles * conversionRate);
    }
}