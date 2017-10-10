package objectsClasses.rectanglePosition_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class RectanglePosition {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] data = parseInput(reader.readLine().split("\\s+"));
        Rectangle first = new Rectangle(data[0], data[1], data[2], data[3]);
        data = parseInput(reader.readLine().split("\\s+"));
        Rectangle second = new Rectangle(data[0], data[1], data[2], data[3]);
        reader.close();
        System.out.println(first.isInside(second) ? "Inside" : "Not Inside");
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}

class Rectangle {

    private int left;
    private int top;
    private int right;
    private int bottom;

    Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.right = this.calcRight(width);
        this.bottom = this.calcBottom(height);
    }

    public boolean isInside(Rectangle other) {
        return this.left >= other.left && this.right <= other.right && this.top <= other.top && this.bottom <= other.bottom;
    }

    private int calcRight(int width) {
        return this.left + width;
    }

    private int calcBottom(int height) {
        return this.right + height;
    }
}