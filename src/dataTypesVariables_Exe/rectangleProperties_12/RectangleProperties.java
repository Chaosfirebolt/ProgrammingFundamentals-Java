package dataTypesVariables_Exe.rectangleProperties_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class RectangleProperties {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        reader.close();

        double perimeter = width * 2 + height * 2;
        double area = width * height;
        double diagonal = Math.sqrt(width * width + height * height);
        DecimalFormat format = new DecimalFormat("0.#############");
        System.out.println(format.format(perimeter));
        System.out.println(format.format(area));
        System.out.println(format.format(diagonal));
    }
}