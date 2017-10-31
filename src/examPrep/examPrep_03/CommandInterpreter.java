package examPrep.examPrep_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ChaosFire on 30.10.2017 г.
 */
public class CommandInterpreter {

    private static final String INVALID = "Invalid input parameters.";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = parseToList(reader.readLine().split("\\s+"));
        String input = reader.readLine();
        StringBuilder output = new StringBuilder();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            int startIndex;
            int count;
            int rollCount;
            switch (data[0]) {
                case "reverse":
                    startIndex = Integer.parseInt(data[2]);
                    count = Integer.parseInt(data[4]);
                    if (validIndex(startIndex, list) && count >= 0) {
                        int endIndex = startIndex + count;
                        if (endIndex > list.size()) {
                            output.append(INVALID).append(System.lineSeparator());
                            break;
                        }
                        reverse(list.subList(startIndex, endIndex));
                    } else {
                        output.append(INVALID).append(System.lineSeparator());
                    }
                    break;
                case "sort":
                    startIndex = Integer.parseInt(data[2]);
                    count = Integer.parseInt(data[4]);
                    if (validIndex(startIndex, list) && count >= 0) {
                        int endIndex = startIndex + count;
                        if (endIndex > list.size()) {
                            output.append(INVALID).append(System.lineSeparator());
                            break;
                        }
                        list.subList(startIndex, endIndex).sort(new StringComparator());
                    } else {
                        output.append(INVALID).append(System.lineSeparator());
                    }
                    break;
                case "rollLeft":
                    rollCount = Integer.parseInt(data[1]);
                    if (rollCount >= 0) {
                        rollLeft(list, rollCount % list.size());
                    } else {
                        output.append(INVALID).append(System.lineSeparator());
                    }
                    break;
                case "rollRight":
                    rollCount = Integer.parseInt(data[1]);
                    if (rollCount >= 0) {
                        rollRight(list, rollCount % list.size());
                    } else {
                        output.append(INVALID).append(System.lineSeparator());
                    }
                    break;
            }

            input = reader.readLine();
        }
        reader.close();
        output.append(String.format("[%s]", String.join(", ", list)));
        System.out.print(output);
    }

    private static void rollLeft(List<String> list, int rollCount) {
        for (int i = 0; i < rollCount; i++) {
            list.add(list.remove(0));
        }
    }

    private static void rollRight(List<String> list, int rollCount) {
        for (int i = 0; i < rollCount; i++) {
            list.add(0, list.remove(list.size() - 1));
        }
    }

    private static void reverse(List<String> list) {
        int bound = list.size() / 2;
        for (int i = 0; i < bound; i++) {
            int j = list.size() - 1 - i;
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    private static boolean validIndex(int index, List<String> list) {
        return index >= 0 && index < list.size();
    }

    private static List<String> parseToList(String[] input) {
        List<String> list = new ArrayList<>(input.length);
        list.addAll(Arrays.asList(input));
        return list;
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int bind = Math.min(o1.length(), o2.length());
        for (int i = 0; i < bind; i++) {
            char c1 = o1.charAt(i);
            char c2 = o2.charAt(i);
            int diff = c1 - c2;
            if (diff == 0) {
                continue;
            }
            if (diff == 32) {
                return -1;
            } else if (diff == -32) {
                return 1;
            } else {
                return Character.compare(c1, c2);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}