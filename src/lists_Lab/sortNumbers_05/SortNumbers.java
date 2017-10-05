package lists_Lab.sortNumbers_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class SortNumbers {

    public static void main(String[] args) throws IOException {
        DecimalFormat format = new DecimalFormat("0.############");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> sorted = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Double::parseDouble)
                .sorted()
                .map(format::format)
                .collect(Collectors.toList());
        reader.close();
        System.out.println(String.join(" <= ", sorted));
    }
}