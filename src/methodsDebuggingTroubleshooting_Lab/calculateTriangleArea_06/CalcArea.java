package methodsDebuggingTroubleshooting_Lab.calculateTriangleArea_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class CalcArea {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        reader.close();
        DecimalFormat format = new DecimalFormat("0.############");
        System.out.print(format.format(area(width, height)));
    }

    private static double area(double width, double height) {
        return width * height / 2;
    }
}