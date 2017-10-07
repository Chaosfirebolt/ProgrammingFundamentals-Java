package dictLambdaStream_Lab.oddOccurrences_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class OddOccurrences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().toLowerCase().split("\\s+");
        reader.close();

        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.replace(word, count + 1);
            }
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                output.append(String.format("%s", entry.getKey())).append(", ");
            }
        }
        if (output.length() > 0) {
            output.delete(output.length() - 2, output.length());
        }
        System.out.print(output);
    }
}