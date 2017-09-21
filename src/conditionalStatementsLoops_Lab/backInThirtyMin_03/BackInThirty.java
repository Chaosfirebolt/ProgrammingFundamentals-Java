package conditionalStatementsLoops_Lab.backInThirtyMin_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class BackInThirty {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hours = Integer.parseInt(reader.readLine());
        int minutes = Integer.parseInt(reader.readLine());
        reader.close();

        minutes += 30;
        if (minutes >= 60) {
            hours++;
            minutes -= 60;
            if (hours == 24) {
                hours = 0;
            }
            System.out.println(formatTime(hours, minutes));
        } else {
            System.out.println(formatTime(hours, minutes));
        }
    }

    private static String formatTime(int hours, int minutes) {
        return String.format("%d:%s", hours, minutes < 10 ? "0" + minutes : "" + minutes);
    }
}