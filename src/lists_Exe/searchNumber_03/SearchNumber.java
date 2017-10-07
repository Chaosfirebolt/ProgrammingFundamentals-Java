package lists_Exe.searchNumber_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 6.10.2017 г.
 */
public class SearchNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = parseList(reader.readLine().split("\\s+"));
        int[] data = parseSearchData(reader.readLine().split("\\s+"));
        reader.close();
        int startIndex = data[1];
        int endIndex = data[0];
        List<Integer> subList = numbers.subList(startIndex, endIndex);
        System.out.print(subList.contains(data[2]) ? "YES!" : "NO!");
    }

    private static int[] parseSearchData(String[] input) {
        int[] data = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            data[i] = Integer.parseInt(input[i]);
        }
        return data;
    }

    private static List<Integer> parseList(String[] input) {
        List<Integer> numbers = new ArrayList<>(input.length);
        for (String str : input) {
            numbers.add(Integer.parseInt(str));
        }
        return numbers;
    }
}