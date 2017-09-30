package methodsDebuggingTroubleshooting_Lab.GreaterOfTwo_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class GetGreater {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();
        switch (type) {
            case "int":
                int a = Integer.parseInt(reader.readLine());
                int b = Integer.parseInt(reader.readLine());
                System.out.println(getMax(a, b));
                break;
            case "char":
                char first = reader.readLine().charAt(0);
                char second = reader.readLine().charAt(0);
                System.out.println(getMax(first, second));
                break;
            case "string":
                System.out.println(getMax(reader.readLine(), reader.readLine()));
                break;
        }
        reader.close();
    }

    private static <T extends Comparable<T>> T getMax(T first, T second) {
        int cmp = first.compareTo(second);
        return cmp >= 0 ? first : second;
    }
}