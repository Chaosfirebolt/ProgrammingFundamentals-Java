package objectsClasses.closestTwoPoints_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class ClosestPoints {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Point[] points = new Point[count];
        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split("\\s+");
            points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        reader.close();

        int index1 = -1;
        int index2 = -1;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point current = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point next = points[j];
                double distance = current.calcDistance(next);
                if (distance < minDistance) {
                    index1 = i;
                    index2 = j;
                    minDistance = distance;
                }
            }
        }
        System.out.printf("%.3f\r\n", minDistance);
        System.out.println(points[index1]);
        System.out.println(points[index2]);
    }
}

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
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