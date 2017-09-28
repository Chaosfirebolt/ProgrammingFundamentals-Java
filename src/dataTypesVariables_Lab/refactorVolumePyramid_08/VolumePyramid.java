package dataTypesVariables_Lab.refactorVolumePyramid_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class VolumePyramid {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Length: ");
        double length = Double.parseDouble(reader.readLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(reader.readLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(reader.readLine());
        reader.close();

        double volume = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}
