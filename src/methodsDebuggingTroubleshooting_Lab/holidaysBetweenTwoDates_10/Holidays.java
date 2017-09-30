package methodsDebuggingTroubleshooting_Lab.holidaysBetweenTwoDates_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class Holidays {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar firstDate = Calendar.getInstance();
        Calendar secondDate = Calendar.getInstance();
        firstDate.setTime(dateFormat.parse(parseToFormat(reader.readLine())));
        secondDate.setTime(dateFormat.parse(parseToFormat(reader.readLine())));
        reader.close();
        int holidays = 0;
        while (firstDate.compareTo(secondDate) <= 0) {
            int dayOfWeek = firstDate.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 7 || dayOfWeek == 1) {
                holidays++;
            }

            firstDate.add(Calendar.DAY_OF_YEAR, 1);
        }
        System.out.println(holidays);
    }

    private static String parseToFormat(String input) {
        String[] data = input.split("\\.");
        data[0] = padLeft(data[0]);
        data[1] = padLeft(data[1]);
        return String.join(".", data);
    }

    private static String padLeft(String string) {
        return string.length() < 2 ? "0" + string : string;
    }
}