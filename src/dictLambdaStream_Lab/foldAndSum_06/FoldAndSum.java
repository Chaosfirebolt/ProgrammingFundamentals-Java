package dictLambdaStream_Lab.foldAndSum_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class FoldAndSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sideCount = list.size() / 4;
        List<Integer> list1 = list.stream()
                .limit(sideCount)
                .collect(Collectors.toList());
        Collections.reverse(list1);

        List<Integer> tempList = list.stream().
                skip(list.size() - sideCount)
                .collect(Collectors.toList());
        Collections.reverse(tempList);
        list1.addAll(tempList);

        List<Integer> list2 = list.subList(sideCount, list.size() - sideCount);
        int[] sum = IntStream.range(0, list1.size())
                .map(index -> list1.get(index) + list2.get(index))
                .toArray();
        print(sum);
    }

    private static void print(int[] sum) {
        StringBuilder output = new StringBuilder();
        for (int num : sum) {
            output.append(num).append(" ");
        }
        System.out.print(output);
    }
}