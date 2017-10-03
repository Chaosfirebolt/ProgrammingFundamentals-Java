package arrays_Exe.largestCommonEnd_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class LargestCommonEnd {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split("\\s+");
        String[] second = reader.readLine().split("\\s+");
        reader.close();
        int bound = Math.min(first.length, second.length);
        int max = scan(first, second, bound);
        System.out.println(max);
    }

    private static int scan(String[] first, String[] second, int bound) {
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < bound; i++) {
            if (first[i].equals(second[i])) {
                leftMax++;
            }
            if (first[first.length - 1 - i].equals(second[second.length - 1 - i])) {
                rightMax++;
            }
        }
        return Math.max(leftMax, rightMax);
    }
}