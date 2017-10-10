package objectsClasses.distanceBetweenPoints_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 9.10.2017 г.
 */
public class DistanceBetweenPoints {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Point point1 = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        input = reader.readLine().split("\\s+");
        Point point2 = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        reader.close();

        System.out.printf("%.3f", point1.calcDistance(point2));
    }
}

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    double calcDistance(Point other) {
        double a = Math.abs(this.x - other.x);
        double b = Math.abs(this.y - other.y);
        return Math.sqrt(a * a + b * b);
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }
}