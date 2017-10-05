package lists_Lab.removeNegativesAndReverse_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class RemoveReverse {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> resultList = process(reader.readLine().split("\\s+"));
        reader.close();
        System.out.println(resultList .size() == 0 ? "empty" : String.join(" ", resultList));
    }

    private static List<String> process(String[] input) {
        List<String> result = new ArrayList<>(input.length);
        for (int i = input.length - 1; i >= 0; i--) {
            if (Integer.parseInt(input[i]) >= 0) {
                result.add(input[i]);
            }
        }
        return result;
    }
}