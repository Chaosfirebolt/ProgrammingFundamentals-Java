package lists_Exe.changeList_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.10.2017 г.
 */
public class ChangeList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = parseInput(reader.readLine().split("\\s+"));
        List<String> result = executeCommands(reader, numbers);
        reader.close();
        System.out.println(String.join(" ", result));
    }

    private static List<String> executeCommands(BufferedReader reader, List<Integer> numbers) throws IOException {
        String command = reader.readLine().toLowerCase();
        while (!command.equals("even") && !command.equals("odd")) {
            String[] data = command.split("\\s+");
            int element = Integer.parseInt(data[1]);
            switch (data[0]) {
                case "delete":
                    for (int i = numbers.size() - 1; i >= 0; i--) {
                        if (numbers.get(i) == element) {
                            numbers.remove(i);
                        }
                    }
                    break;
                case "insert":
                    int position = Integer.parseInt(data[2]);
                    numbers.add(position, element);
                    break;
            }

            command = reader.readLine().toLowerCase();
        }

        List<String> result;
        switch (command) {
            case "even":
                result = getElements(numbers, 0);
                break;
            case "odd":
                result = getElements(numbers, 1);
                break;
            default:
                result = new ArrayList<>();
                break;
        }
        return result;
    }

    private static List<String> getElements(List<Integer> numbers, int remainder) {
        List<String> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == remainder) {
                result.add(Integer.toString(number));
            }
        }
        return result;
    }

    private static List<Integer> parseInput(String[] input) {
        List<Integer> numbers = new ArrayList<>(input.length);
        for (String str : input) {
            numbers.add(Integer.parseInt(str));
        }
        return numbers;
    }
}