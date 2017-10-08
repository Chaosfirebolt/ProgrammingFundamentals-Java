package dictLambdaStream_Exe.logsAggregator_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 8.10.2017 г.
 */
public class LogsAggregator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Map<String, Integer> userTimes = new TreeMap<>();
        Map<String, Set<String>> userIps = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int time = Integer.parseInt(data[2]);

            Set<String> ips = userIps.get(user);
            if (ips == null) {
                ips = new TreeSet<>();
                ips.add(ip);
                userIps.put(user, ips);
                userTimes.put(user, time);
            } else {
                ips.add(ip);
                userTimes.replace(user, userTimes.get(user) + time);
            }
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : userTimes.entrySet()) {
            output.append(String.format("%s: %d [%s]", entry.getKey(), entry.getValue(), String.join(", ", userIps.get(entry.getKey()))))
                    .append(System.lineSeparator());
        }
        System.out.print(output);
    }
}