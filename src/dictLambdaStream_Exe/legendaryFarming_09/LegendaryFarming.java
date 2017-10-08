package dictLambdaStream_Exe.legendaryFarming_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ChaosFire on 8.10.2017 г.
 */
public class LegendaryFarming {

    private static final String FRAGMENTS = "fragments";
    private static final String MOTES = "motes";
    private static final String SHARDS = "shards";
    private static final int THRESHOLD = 250;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Map<String, Integer> keyMaterials = initKeyMaterials();
        Map<String, Integer> junk = new TreeMap<>();
        Map<String, String> legendaries = initLegendaryMap();
        while (input != null && !input.isEmpty()) {
            String[] materials = input.toLowerCase().split("\\s+");
            for (int i = 0; i < materials.length; i += 2) {
                String material = materials[i + 1];
                int quantity = Integer.parseInt(materials[i]);
                if (isKeyMat(material)) {
                    int newValue = keyMaterials.get(material) + quantity;
                    keyMaterials.replace(material, newValue);
                    if (newValue >=  THRESHOLD) {
                        reader.close();
                        keyMaterials.replace(material, newValue - THRESHOLD);
                        print(legendaries.get(material), keyMaterials, junk);
                        return;
                    }
                } else {
                    Integer count = junk.get(material);
                    if (count == null) {
                        junk.put(material, quantity);
                    } else {
                        junk.replace(material, count + quantity);
                    }
                }
            }

            input = reader.readLine();
        }
    }

    private static void print(String legendary, Map<String, Integer> keyMats, Map<String, Integer> junk) {
        StringBuilder output = new StringBuilder(String.format("%s obtained!", legendary));
        keyMats.entrySet()
                .stream()
                .sorted(comparator())
                .forEach(p -> output.append(System.lineSeparator()).append(formatMaterial(p.getKey(), p.getValue())));
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            output.append(System.lineSeparator()).append(formatMaterial(entry.getKey(), entry.getValue()));
        }
        System.out.print(output);
    }

    private static String formatMaterial(String material, int quantity) {
        return String.format("%s: %d", material, quantity);
    }

    private static Comparator<Map.Entry<String, Integer>> comparator() {
        Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        comparator = comparator.thenComparing(Comparator.comparing(Map.Entry::getKey));
        return comparator;
    }

    private static Map<String, Integer> initKeyMaterials() {
        Map<String, Integer> map = new HashMap<>();
        map.put(FRAGMENTS, 0);
        map.put(MOTES, 0);
        map.put(SHARDS, 0);
        return map;
    }

    private static Map<String, String> initLegendaryMap() {
        Map<String, String> map = new HashMap<>();
        map.put(FRAGMENTS, "Valanyr");
        map.put(MOTES, "Dragonwrath");
        map.put(SHARDS, "Shadowmourne");
        return map;
    }

    private static boolean isKeyMat(String material) {
        return material.equals(FRAGMENTS) || material.equals(MOTES) || material.equals(SHARDS);
    }
}