package conditionalStatementsLoops_Exe.caloriesCounter_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class CaloriesCounter {

    private static Map<String, Integer> ingredientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        initMap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int total = 0;
        for (int i = 0; i < count; i++) {
            String ingredient = reader.readLine().toLowerCase();
            Integer calories = ingredientMap.get(ingredient);
            if (calories != null) {
                total += calories;
            }
        }
        reader.close();
        System.out.printf("Total calories: %d", total);
    }

    private static void initMap() {
        ingredientMap.put("cheese", 500);
        ingredientMap.put("tomato sauce", 150);
        ingredientMap.put("salami", 600);
        ingredientMap.put("pepper", 50);
    }
}