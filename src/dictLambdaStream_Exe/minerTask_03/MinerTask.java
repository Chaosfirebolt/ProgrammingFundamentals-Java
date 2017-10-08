package dictLambdaStream_Exe.minerTask_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class MinerTask {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> resources = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("stop")) {
            String resource = input;
            long quantity = Long.parseLong(reader.readLine());
            Long currentQuantity = resources.get(resource);
            if (currentQuantity == null) {
                resources.put(resource, quantity);
            } else {
                resources.replace(resource, currentQuantity + quantity);
            }

            input = reader.readLine();
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            output.append(String.format("%s -> %s", entry.getKey(), entry.getValue())).append(System.lineSeparator());
        }
        System.out.print(output);
    }
}