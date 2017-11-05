package exam_20171105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 5.11.2017 г.
 */
public class AnonymousCache {

    private static final String END = "thetinggoesskrra";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        Pattern pattern = Pattern.compile("^(.+?)\\s+->\\s+(\\d+)\\s+\\|\\s+(.+?)$");
        Map<String, LinkedList<Data>> dataSets = new HashMap<>();
        Map<String, LinkedList<Data>> cache = new HashMap<>();
        while (!input.equals(END)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String key = matcher.group(1);
                long size = Long.parseLong(matcher.group(2));
                String set = matcher.group(3);
                LinkedList<Data> dataSet = dataSets.get(set);
                Data data = new Data(key, size);
                if (dataSet != null) {
                    dataSet.add(data);
                } else {
                    if (!cache.containsKey(set)) {
                        cache.put(set, new LinkedList<>());
                    }
                    cache.get(set).add(data);
                }
            } else {
                if (cache.containsKey(input)) {
                    dataSets.put(input, cache.remove(input));
                } else {
                    dataSets.put(input, new LinkedList<>());
                }
            }

            input = reader.readLine().trim();
        }
        reader.close();

        String set = "";
        long maxSize = Long.MIN_VALUE;
        for (Map.Entry<String, LinkedList<Data>> entry : dataSets.entrySet()) {
            long size = 0;
            for (Data data : entry.getValue()) {
                size += data.getSize();
            }
            if (size > maxSize) {
                maxSize = size;
                set = entry.getKey();
            }
        }

        LinkedList<Data> dataSet = dataSets.get(set);
        StringBuilder output = new StringBuilder();
        if (dataSet != null) {
            output.append(String.format("Data Set: %s, Total Size: %d", set, maxSize));
            for (Data data : dataSet) {
                output.append(System.lineSeparator()).append(String.format("$.%s", data.getKey()));
            }
        }
        System.out.print(output);
    }
}

class Data {

    private String key;
    private long size;

    Data(String key, long size) {
        this.setKey(key);
        this.setSize(size);
    }

    String getKey() {
        return this.key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    long getSize() {
        return this.size;
    }

    private void setSize(long size) {
        this.size = size;
    }
}