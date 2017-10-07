package dictLambdaStream_Lab.largestThreeNumbers_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class LargestThreeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(num -> Integer.toString(num))
                .collect(Collectors.toList());
        reader.close();
        System.out.println(String.join(" ", numbers));
    }
}