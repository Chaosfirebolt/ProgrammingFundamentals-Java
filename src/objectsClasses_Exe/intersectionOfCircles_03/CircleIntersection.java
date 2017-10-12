package objectsClasses_Exe.intersectionOfCircles_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class CircleIntersection {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Circle firstCircle = parseInput(reader.readLine().split("\\s+"));
        Circle secondCircle = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        System.out.println(firstCircle.intersects(secondCircle) ? "Yes" : "No");
    }

    private static Circle parseInput(String[] input) {
        return new Circle(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])), Integer.parseInt(input[2]));
    }
}

class Circle {

    private Point center;
    private int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    boolean intersects(Circle other) {
        double distance = this.center.distance(other.center);
        return distance <= this.radius + other.radius;
    }
}

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point other) {
        double a = Math.abs(this.x - other.x);
        double b = Math.abs(this.y - other.y);
        return Math.sqrt(a * a + b * b);
    }
}