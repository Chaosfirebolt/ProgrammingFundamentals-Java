package dataTypesVariables_Lab.circleArea_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class CircleArea {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double radius = Double.parseDouble(reader.readLine());
        reader.close();
        System.out.printf("%.12f", Math.PI * radius * radius);
    }
}