package methodsDebuggingTroubleshooting_Lab.temperatureConversion_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class FahrenheitToCelsius {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double fahrenheit = Double.parseDouble(reader.readLine());
        reader.close();
        System.out.printf("%.2f", toCelsius(fahrenheit));
    }

    private static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}