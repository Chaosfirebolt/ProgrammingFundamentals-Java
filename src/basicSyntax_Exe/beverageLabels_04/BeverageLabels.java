package basicSyntax_Exe.beverageLabels_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 19.9.2017 г.
 */
public class BeverageLabels {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        double volume = Double.parseDouble(reader.readLine());
        int energy = Integer.parseInt(reader.readLine());
        int sugar = Integer.parseInt(reader.readLine());
        reader.close();

        final int rate = 100;
        DecimalFormat format = new DecimalFormat("0.######");
        String totalEnergy = format.format(volume * energy / rate);
        String totalSugar = format.format(volume * sugar / rate);
        System.out.printf("%sml %s:\n%skcal, %sg sugars", format.format(volume), name, totalEnergy, totalSugar);
    }
}