package dataTypesVariables_Exe.centuriesToNanoseconds_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class CenturiesNanoseconds {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int centuries = Integer.parseInt(reader.readLine());
        reader.close();
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;
        long seconds = (long) minutes * 60L;
        long milliseconds = seconds * 1000L;

        BigInteger thousand = new BigInteger(Integer.toString(1000));
        BigInteger microseconds = new BigInteger(Long.toString(milliseconds)).multiply(thousand);
        BigInteger nanoseconds = microseconds.multiply(thousand);

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes = %d seconds = %d milliseconds = %d microseconds =" +
                " %d nanoseconds", centuries, years, days, hours, minutes, seconds, milliseconds, microseconds, nanoseconds);
    }
}