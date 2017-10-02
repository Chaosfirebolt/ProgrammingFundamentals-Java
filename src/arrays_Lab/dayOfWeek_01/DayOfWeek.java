package arrays_Lab.dayOfWeek_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 2.10.2017 г.
 */
public class DayOfWeek {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(reader.readLine());
        reader.close();

        String[] days = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        try {
            System.out.println(days[day - 1]);
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Invalid Day!");
        }
    }
}