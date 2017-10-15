package regEx_Exe.queryMess_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class QueryMess {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder output = new StringBuilder();
        while (!input.equals("END")) {
            processInput(input, output);
            input = reader.readLine();
        }
        reader.close();
        System.out.print(output);
    }

    private static void processInput(String input, StringBuilder output) {
        String[] tokens = input.split("\\?");
        String query = tokens.length > 1 ? tokens[1] : input;
        tokens = query.split("&");
        Map<String, LinkedList<String>> pairs = new LinkedHashMap<>();
        for (String token : tokens) {
            String[] data = token.split("=");
            String key = decodeSpaces(data[0]);
            String value = decodeSpaces(data[1]);
            if (!pairs.containsKey(key)) {
                pairs.put(key, new LinkedList<>());
            }
            pairs.get(key).addLast(value);
        }
        for (Map.Entry<String, LinkedList<String>> entry : pairs.entrySet()) {
            output.append(String.format("%s=[%s]", entry.getKey(), String.join(", ", entry.getValue())));
        }
        output.append(System.lineSeparator());
    }

    private static String decodeSpaces(String string) {
        String temp = string.replaceAll("\\+|%20", " ");
        return temp.replaceAll("\\s+", " ").trim();
    }
}