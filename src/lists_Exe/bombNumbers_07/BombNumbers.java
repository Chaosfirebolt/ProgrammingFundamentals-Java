package lists_Exe.bombNumbers_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class BombNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = parseInput(reader.readLine().split("\\s+"));
        List<Integer> data = parseInput(reader.readLine().split("\\s+"));
        reader.close();

        int number = data.get(0);
        int power = data.get(1);
        bomb(list, number, power);
        System.out.println(sum(list));
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            sum += number;
        }
        return sum;
    }

    private static void bomb(List<Integer> list, int number, int power) {
        int indexOf = list.indexOf(number);
        while (indexOf != -1) {
            int index = Math.max(0, indexOf - power);
            int count = Math.min(list.size() - 1, indexOf + power) - index + 1;
            for (int i = 0; i < count; i++) {
                list.remove(index);
            }
            indexOf = list.indexOf(number);
        }
    }

    private static List<Integer> parseInput(String[] input) {
        List<Integer> numbers = new ArrayList<>(input.length);
        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}