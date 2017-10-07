package lists_Exe.arrayManipulator_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ChaosFire on 6.10.2017 г.
 */
public class ArrayManipulator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = parseInput(reader.readLine().split("\\s+"), 0);
        String input = reader.readLine();
        StringBuilder output = new StringBuilder();
        while (!input.equals("print")) {
            String[] data = input.split("\\s+");
            int index;
            int element;
            switch (data[0]) {
                case "add":
                    index = Integer.parseInt(data[1]);
                    element = Integer.parseInt(data[2]);
                    list.add(index, element);
                    break;
                case "addMany":
                    index = Integer.parseInt(data[1]);
                    List<Integer> elements = parseInput(input.split("\\s+"), 2);
                    for (Integer integer : elements) {
                        list.add(index++, integer);
                    }
                    break;
                case "contains":
                    element = Integer.parseInt(data[1]);
                    int elemIndex = list.indexOf(element);
                    output.append(elemIndex).append(System.lineSeparator());
                    break;
                case "remove":
                    index = Integer.parseInt(data[1]);
                    list.remove(index);
                    break;
                case "shift":
                    Collections.rotate(list, list.size() - Integer.parseInt(data[1]) % list.size());
                    break;
                case "sumPairs":
                    list = sumPairs(list);
                    break;
            }

            input = reader.readLine();
        }
        reader.close();
        output.append(print(list));
        System.out.println(output);
    }

    private static String print(List<Integer> list) {
        StringBuilder sb = new StringBuilder("[");
        if (list.size() > 0) {
            sb.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                sb.append(", ").append(list.get(i));
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static List<Integer> sumPairs(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            int first = list.get(i);
            int second = i + 1 < list.size() ? list.get(i + 1) : 0;
            newList.add(first + second);
        }
        return newList;
    }

    private static List<Integer> parseInput(String[] input, int startIndex) {
        List<Integer> numbers = new ArrayList<>(input.length);
        for (int i = startIndex; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        return numbers;
    }
}