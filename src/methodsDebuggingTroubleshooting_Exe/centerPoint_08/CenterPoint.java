package methodsDebuggingTroubleshooting_Exe.centerPoint_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class CenterPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x1 = Double.parseDouble(reader.readLine());
        double y1 = Double.parseDouble(reader.readLine());
        double x2 = Double.parseDouble(reader.readLine());
        double y2 = Double.parseDouble(reader.readLine());

        double firstDistance = calcDistance(x1, y1);
        double secondDistance = calcDistance(x2, y2);
        DecimalFormat format = new DecimalFormat("0.############");
        if (firstDistance <= secondDistance) {
            System.out.printf("(%s, %s)", format.format(x1), format.format(y1));
        } else {
            System.out.printf("(%s, %s)", format.format(x2), format.format(y2));
        }
    }

    private static double calcDistance(double x, double y) {
        double a = Math.abs(x);
        double b = Math.abs(y);
        return Math.sqrt(a * a + b * b);
    }
}