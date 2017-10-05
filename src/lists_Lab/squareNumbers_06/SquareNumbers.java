package lists_Lab.squareNumbers_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class SquareNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> squareNumbers = process(reader.readLine().split("\\s+"));
        reader.close();
        print(squareNumbers);
    }

    private static void print(List<Integer> squareNumbers) {
        StringBuilder output = new StringBuilder();
        for (Integer squareNumber : squareNumbers) {
            output.append(squareNumber).append(" ");
        }
        System.out.print(output);
    }

    private static List<Integer> process(String[] input) {
        List<Integer> result = new ArrayList<>();
        for (String str : input) {
            int number = Integer.parseInt(str);
            if (Math.sqrt(number) % 1 == 0) {
                result.add(number);
            }
        }
        result.sort(Comparator.reverseOrder());
        return result;
    }
}