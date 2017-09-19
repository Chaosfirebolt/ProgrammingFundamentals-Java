package basicSyntax_Exe.rectangleArea_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 19.9.2017 г.
 */
public class RectangleArea {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        reader.close();
        System.out.printf("%.2f", a * b);
    }
}