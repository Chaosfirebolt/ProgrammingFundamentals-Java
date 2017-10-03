package arrays_Exe.foldAndSum_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class FoldSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseInput(reader.readLine().split("\\s+"));
        reader.close();

        int lowBind = numbers.length / 4;
        int highBind = numbers.length - numbers.length / 4;
        List<Integer> firstList = getUpperArr(numbers, lowBind, highBind);
        List<Integer> secondList = getDownArr(numbers, lowBind, highBind);
        print(firstList, secondList);
    }

    private static void print(List<Integer> first, List<Integer> second) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < first.size(); i++) {
            output.append(first.get(i) + second.get(i)).append(" ");
        }
        System.out.println(output);
    }

    private static List<Integer> getUpperArr(int[] numbers, int lowBind, int highBind) {
        List<Integer> result = new ArrayList<>();
        int size = numbers.length / 4;

        int[] range = copyRange(numbers, size, 0, lowBind);
        reverseArray(range);
        addAll(result, range);

        range = copyRange(numbers, size, highBind, numbers.length);
        reverseArray(range);
        addAll(result, range);

        return result;
    }

    private static List<Integer> getDownArr(int[] numbers, int lowBind, int highBind) {
        List<Integer> result = new ArrayList<>();
        addAll(result, copyRange(numbers, numbers.length / 2, lowBind, highBind));
        return result;
    }

    private static void reverseArray(int[] array) {
        int midPoint = array.length / 2;
        for (int i = 0; i < midPoint; i++) {
            swap(array, i, array.length - 1 - i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void addAll(List<Integer> list, int[] array) {
        for (int num : array) {
            list.add(num);
        }
    }

    @SuppressWarnings("ManualArrayCopy")
    private static int[] copyRange(int[] numbers, int size, int lowBind, int highBind) {
        int[] copy = new int[size];
        for (int i = lowBind; i < highBind; i++) {
            copy[i - lowBind] = numbers[i];
        }
        return copy;
    }

    private static int[] parseInput(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}