package methodsDebuggingTroubleshooting_Exe.cubeProperties_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class CubeProperty {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double side = Double.parseDouble(reader.readLine());
        String prop = reader.readLine();
        reader.close();
        switch (prop) {
            case "face":
                System.out.printf("%.2f", face(side));
                break;
            case "volume":
                System.out.printf("%.2f", volume(side));
                break;
            case "space":
                System.out.printf("%.2f", space(side));
                break;
            case "area":
                System.out.printf("%.2f", area(side));
                break;
        }
    }

    private static double face(double side) {
        return Math.sqrt(2 * side * side);
    }

    private static double volume(double side) {
        return Math.pow(side, 3);
    }

    private static double space(double side) {
        return Math.sqrt(3 * side * side);
    }

    private static double area(double side) {
        return 6 * side * side;
    }
}