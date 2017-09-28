package dataTypesVariables_Lab.centuriesToMinutes_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class CenturiesToMinutes {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int centuries = Integer.parseInt(reader.readLine());
        reader.close();
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = days * 24;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, hours * 60);
    }
}