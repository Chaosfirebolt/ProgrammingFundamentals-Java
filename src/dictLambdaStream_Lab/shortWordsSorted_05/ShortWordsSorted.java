package dictLambdaStream_Lab.shortWordsSorted_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class ShortWordsSorted {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> sorted = Arrays.stream(reader.readLine().toLowerCase().split("[.,:;()\\[\\]\"'\\\\/!? ]"))
                .filter(w -> !w.isEmpty() && w.length() < 5)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        reader.close();
        System.out.println(String.join(", ", sorted));
    }
}