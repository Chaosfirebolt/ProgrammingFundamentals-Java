package lists_Lab.appendLists_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class AppendLists {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> resultList = processInput(reader.readLine());
        reader.close();
        System.out.println(String.join(" ", resultList));
    }

    private static List<String> processInput(String input) {
        String[] lists = input.split("\\|");
        List<String> result = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            String[] numbers = lists[i].split("\\s+");
            for (String number : numbers) {
                if (!number.equals("")) {
                    result.add(number);
                }
            }
        }
        return result;
    }
}