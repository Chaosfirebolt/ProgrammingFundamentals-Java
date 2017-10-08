package dictLambdaStream_Exe.handsOfCards_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class HandsOfCards {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> hands = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split(":\\s+");
            String name = data[0];
            String[] newCards = data[1].split(",\\s+");
            Set<String> currCards = hands.get(name);
            if (currCards == null) {
                currCards = new HashSet<>(Arrays.asList(newCards));
                hands.put(name, currCards);
            } else {
                currCards.addAll(Arrays.asList(newCards));
            }

            input = reader.readLine();
        }
        reader.close();

        Map<String, Integer> valueMap = initValueMap();
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : hands.entrySet()) {
            int sum = 0;
            Set<String> cards = entry.getValue();
            for (String card : cards) {
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);
                sum += valueMap.get(power) * valueMap.get(type);
            }
            output.append(String.format("%s: %d", entry.getKey(), sum)).append(System.lineSeparator());
        }
        System.out.print(output);
    }

    private static Map<String, Integer> initValueMap() {
        Map<String, Integer> map = new HashMap<>();
        String[] powers = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        for (int i = 0; i < powers.length; i++) {
            map.put(powers[i], i + 2);
        }

        String[] types = new String[] { "C", "D", "H", "S" };
        for (int i = 0; i < types.length; i++) {
            map.put(types[i], i + 1);
        }
        return map;
    }
}