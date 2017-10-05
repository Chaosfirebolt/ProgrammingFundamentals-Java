package lists_Lab.sumAdjacentEqualNumbers_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class SumAdjacent {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        sumAdjacent(numbers);
        print(numbers);
    }

    private static void print(List<Double> numbers) {
        DecimalFormat format = new DecimalFormat("0.############");
        StringBuilder output = new StringBuilder();
        for (Double number : numbers) {
            output.append(format.format(number)).append(" ");
        }
        System.out.print(output);
    }

    private static void sumAdjacent(List<Double> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            double prev = numbers.get(i - 1);
            if (prev != numbers.get(i)) {
                continue;
            }
            double removed = numbers.remove(i);
            numbers.set(i - 1, prev + removed);
            sumAdjacent(numbers);
        }
    }

    private static List<Double> parseInput(String[] input) {
        List<Double> numbers = new ArrayList<>(input.length);
        for (String number : input) {
            numbers.add(Double.parseDouble(number));
        }
        return numbers;
    }
}