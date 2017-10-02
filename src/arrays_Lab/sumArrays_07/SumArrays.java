package arrays_Lab.sumArrays_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class SumArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> first = parseInput(reader.readLine());
        List<Integer> second = parseInput(reader.readLine());
        reader.close();
        equalize(first, second);
        for (int i = 0; i < first.size(); i++) {
            System.out.println(first.get(i) + second.get(i));
        }
    }

    private static void equalize(List<Integer> first, List<Integer> second) {
        if (first.size() > second.size()) {
            duplicate(second, first.size());
        } else {
            duplicate(first, second.size());
        }
    }

    private static void duplicate(List<Integer> list, int targetLength) {
        int index = 0;
        int size = list.size();
        while (list.size() < targetLength) {
            list.add(list.get(index));
            index = (index + 1) % size;
        }
    }

    private static List<Integer> parseInput(String input) {
        String[] numbers = input.split("\\s+");
        List<Integer> list = new ArrayList<>(numbers.length);
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}