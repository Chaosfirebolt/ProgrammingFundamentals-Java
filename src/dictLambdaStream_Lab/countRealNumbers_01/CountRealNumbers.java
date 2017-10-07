package dictLambdaStream_Lab.countRealNumbers_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class CountRealNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();
        Map<Double, Integer> counts = new TreeMap<>();
        for (double number : numbers) {
            Integer count = counts.get(number);
            if (count == null) {
                counts.put(number, 1);
            } else {
                counts.replace(number, count + 1);
            }
        }

        DecimalFormat format = new DecimalFormat("0.############");
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            output.append(String.format("%s -> %d", format.format(entry.getKey()), entry.getValue())).append(System.lineSeparator());
        }
        System.out.print(output);
    }

    private static double[] parseInput(String[] input) {
        double[] result = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Double.parseDouble(input[i]);
        }
        return result;
    }
}