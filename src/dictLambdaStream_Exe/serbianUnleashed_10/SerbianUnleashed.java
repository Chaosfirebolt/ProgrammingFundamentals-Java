package dictLambdaStream_Exe.serbianUnleashed_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 8.10.2017 г.
 */
public class SerbianUnleashed {

    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Long>> venueSingerIncome = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(.+?)\\s+@(.+?)\\s+(\\d+)\\s+(\\d+)");
        String input = reader.readLine();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                input = reader.readLine();
                continue;
            }
            String singer = matcher.group(1);
            String venue = matcher.group(2);
            long income = Long.parseLong(matcher.group(3)) * Long.parseLong(matcher.group(4));
            if (venueSingerIncome.containsKey(venue)) {
                Long currIncome = venueSingerIncome.get(venue).get(singer);
                if (currIncome == null) {
                    venueSingerIncome.get(venue).put(singer, income);
                } else {
                    venueSingerIncome.get(venue).replace(singer, currIncome + income);
                }
            } else {
                venueSingerIncome.put(venue, new LinkedHashMap<>());
                venueSingerIncome.get(venue).put(singer, income);
            }

            input = reader.readLine();
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Map<String, Long>> entry : venueSingerIncome.entrySet()) {
            output.append(entry.getKey()).append(System.lineSeparator());
            entry.getValue().entrySet()
                    .stream()
                    .sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue()))
                    .forEach(en -> output.append(String.format("#  %s -> %d", en.getKey(), en.getValue())).append(System.lineSeparator()));
        }
        System.out.print(output);
    }
}