package dataTypesVariables_Exe.convertSpeedUnits_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 29.9.2017 г.
 */
public class ConvertSpeedUnits {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float meters = Float.parseFloat(reader.readLine());
        float hours = Float.parseFloat(reader.readLine());
        float minutes = Float.parseFloat(reader.readLine());
        float seconds = Float.parseFloat(reader.readLine());
        reader.close();
        DecimalFormat format = new DecimalFormat("0.#######");
        System.out.printf("%s\r\n", format.format(meters / (seconds + minutes * 60 + hours * 3600)));
        System.out.printf("%s\r\n", format.format(meters / 1000 / (hours + minutes / 60 + seconds / 3600)));
        System.out.printf("%s", format.format(meters / 1609 / (hours + minutes / 60 + seconds / 3600)));
    }
}