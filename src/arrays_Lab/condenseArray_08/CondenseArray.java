package arrays_Lab.condenseArray_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class CondenseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = parseInput(reader.readLine());
        reader.close();
        int result = condense(numbers);
        System.out.println(result);
    }

    private static int condense(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }
        List<Integer> nextList = new ArrayList<>();
        for (int index = 0; index < numbers.size() - 1; index++) {
            nextList.add(numbers.get(index) + numbers.get(index + 1));
        }
        return condense(nextList);
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