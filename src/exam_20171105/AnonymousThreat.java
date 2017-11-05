package exam_20171105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 5.11.2017 г.
 */
@SuppressWarnings("all")
public class AnonymousThreat {

    private static final String END = "3:1";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = parseInput(reader.readLine().split("\\s+"));
        String input = reader.readLine();
        while (!input.equals(END)) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]) + 1;
                    Interval interval = Interval.parseInterval(startIndex, endIndex, list.size());
                    if (interval == null) {
                        break;
                    }
                    merge(interval.getStart(), interval.getEnd(), list);
                    break;
                case "divide":
                    int index = Integer.parseInt(data[1]);
                    int partitions = Integer.parseInt(data[2]);
                    list = divide(index, partitions, list);
                    break;
            }

            input = reader.readLine();
        }
        reader.close();
        System.out.print(String.join(" ", list));
    }

    private static List<String> divide(int index, int partitions, List<String> list) {
        List<String> newList = new ArrayList<>(list.size() + partitions);
        newList.addAll(list.subList(0, index));
        String element = list.get(index);
        int length = element.length() / partitions;
        int currIndex = 0;
        int count = 1;
        while (count < partitions) {
            int endIndex = currIndex + length;
            newList.add(element.substring(currIndex, endIndex));
            currIndex = endIndex;
            count++;
        }
        newList.add(element.substring(currIndex));
        newList.addAll(list.subList(index + 1, list.size()));
        return newList;
    }

    private static void merge(int startIndex, int endIndex, List<String> list) {
        StringBuilder joined = new StringBuilder();
        for (int i = startIndex + 1; i < endIndex; i++) {
            String removed = list.remove(startIndex + 1);
            joined.append(removed);
        }
        list.set(startIndex, list.get(startIndex) + joined.toString());
    }

    private static List<String> parseInput(String[] input) {
        List<String> result = new ArrayList<>(input.length);
        for (String str : input) {
            result.add(str);
        }
        return result;
    }
}

class Interval {

    private int start;
    private int end;

    private Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return this.start;
    }

    int getEnd() {
        return this.end;
    }

    static Interval parseInterval(int start, int end, int length) {
        if (end < 0 || start >= length) {
            return null;
        }
        return new Interval(Math.max(0, start), Math.min(length, end));
    }
}