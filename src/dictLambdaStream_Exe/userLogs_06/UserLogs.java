package dictLambdaStream_Exe.userLogs_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class UserLogs {

    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Integer>> users = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ip = getValue(data, 0);
            String username = getValue(data, 2);


            Map<String, Integer> ipAddresses = users.get(username);
            if (ipAddresses == null) {
                ipAddresses = new LinkedHashMap<>();
                ipAddresses.put(ip, 1);
                users.put(username, ipAddresses);
            } else {
                Integer count = ipAddresses.get(ip);
                if (count == null) {
                    ipAddresses.put(ip, 1);
                } else {
                    ipAddresses.replace(ip, count + 1);
                }
            }

            input = reader.readLine();
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        users.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(pair -> output.append(String.format("%s:", pair.getKey())).append(System.lineSeparator())
                        .append(String.join(", ",
                                pair.getValue().entrySet()
                                        .stream()
                                        .map(ip -> String.format("%s => %d", ip.getKey(), ip.getValue()))
                                        .collect(Collectors.toList())))
                        .append(".").append(System.lineSeparator()));
        System.out.print(output);
    }

    private static String getValue(String[] data, int index) {
        return data[index].split("=")[1];
    }
}