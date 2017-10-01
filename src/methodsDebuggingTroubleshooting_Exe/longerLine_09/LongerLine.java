package methodsDebuggingTroubleshooting_Exe.longerLine_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class LongerLine {

    private static DecimalFormat format = new DecimalFormat("0.############");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x1 = Double.parseDouble(reader.readLine());
        double y1 = Double.parseDouble(reader.readLine());
        double x2 = Double.parseDouble(reader.readLine());
        double y2 = Double.parseDouble(reader.readLine());
        double x3 = Double.parseDouble(reader.readLine());
        double y3 = Double.parseDouble(reader.readLine());
        double x4 = Double.parseDouble(reader.readLine());
        double y4 = Double.parseDouble(reader.readLine());
        reader.close();

        double firstLength = calcDistance(x1, y1, x2, y2);
        double secondLength = calcDistance(x3, y3, x4, y4);
        System.out.println(firstLength >= secondLength ? line(x1, y1, x2, y2) : line(x3, y3, x4, y4));
    }

    private static String line(double x1, double y1, double x2, double y2) {
        double firstDistance = calcDistance(x1, y1, 0, 0);
        double secondDistance = calcDistance(x2, y2, 0, 0);
        return firstDistance <= secondDistance ? formattedLine(x1, y1, x2, y2) : formattedLine(x2, y2, x1, y1);
    }

    private static String formattedLine(double x1, double y1, double x2, double y2) {
        return String.format("(%s, %s)(%s, %s)", format.format(x1), format.format(y1), format.format(x2), format.format(y2));
    }

    private static double calcDistance(double x1, double y1, double x2, double y2) {
        double a = Math.abs(x1 - x2);
        double b = Math.abs(y1 - y2);
        return Math.sqrt(a * a + b * b);
    }
}