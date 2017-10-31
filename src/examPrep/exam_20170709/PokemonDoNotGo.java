package examPrep.exam_20170709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class PokemonDoNotGo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = parseInput(reader.readLine().split("\\s+"));
        long sum = 0;
        int removed;
        while (list.size() > 0) {
            int index = Integer.parseInt(reader.readLine());
            if (index < 0) {
                removed = list.get(0);
                list.set(0, list.get(list.size() - 1));
            } else if (index >= list.size()) {
                removed = list.get(list.size() - 1);
                list.set(list.size() - 1, list.get(0));
            } else {
                removed = list.remove(index);
            }

            sum += removed;
            for (int i = 0; i < list.size(); i++) {
                int element = list.get(i);
                if (element <= removed) {
                    list.set(i, element + removed);
                } else {
                    list.set(i, element - removed);
                }
            }
        }
        reader.close();
        System.out.println(sum);
    }

    private static List<Integer> parseInput(String[] input) {
        List<Integer> list = new ArrayList<>(input.length);
        for (String str : input) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}