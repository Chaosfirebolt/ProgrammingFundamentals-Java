package methodsDebuggingTroubleshooting_Exe.geometryCalculator_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class GeometryCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String figure = reader.readLine();
        double side = Double.parseDouble(reader.readLine());
        double height;
        switch (figure) {
            case "triangle":
                height = Double.parseDouble(reader.readLine());
                System.out.printf("%.2f", triangleArea(side, height));
                break;
            case "square":
                System.out.printf("%.2f", rectArea(side, side));
                break;
            case "rectangle":
                height = Double.parseDouble(reader.readLine());
                System.out.printf("%.2f", rectArea(side, height));
                break;
            case "circle":
                System.out.printf("%.2f", circleArea(side));
                break;
        }
    }

    private static double circleArea(double radius) {
        return Math.PI * rectArea(radius, radius);
    }

    private static double triangleArea(double width, double height) {
        return rectArea(width, height) / 2;
    }

    private static double rectArea(double width, double height) {
        return width * height;
    }
}