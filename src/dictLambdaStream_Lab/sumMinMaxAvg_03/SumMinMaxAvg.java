package dictLambdaStream_Lab.sumMinMaxAvg_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class SumMinMaxAvg {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();
        DecimalFormat format = new DecimalFormat("0.############");
        System.out.printf("Sum = %d%s", numbers.stream().mapToInt(Integer::intValue).sum(), System.lineSeparator());
        System.out.printf("Min = %d%s", numbers.stream().min(Integer::compareTo).orElseGet(null), System.lineSeparator());
        System.out.printf("Max = %d%s", numbers.stream().max(Integer::compareTo).orElseGet(null), System.lineSeparator());
        System.out.printf("Average = %s", format.format(numbers.stream().mapToInt(Integer::intValue).average().orElseGet(null)));
    }
}