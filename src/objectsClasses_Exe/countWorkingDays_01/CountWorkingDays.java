package objectsClasses_Exe.countWorkingDays_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class CountWorkingDays {

    public static void main(String[] args) throws IOException, ParseException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar currDate = Calendar.getInstance();
        currDate.setTime(dateFormat.parse(reader.readLine()));

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(dateFormat.parse(reader.readLine()));
        reader.close();

        Set<Date> holidays = holidays();
        int count = 0;
        while (currDate.compareTo(endDate) <= 0) {
            int weekday = currDate.get(Calendar.DAY_OF_WEEK);
            Date date = new Date(currDate.get(Calendar.DAY_OF_MONTH), currDate.get(Calendar.MONTH) + 1);
            if (weekday != Calendar.SATURDAY && weekday != Calendar.SUNDAY && !holidays.contains(date)) {
                count++;
            }

            currDate.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(count);

    }

    private static Set<Date> holidays() {
        Date[] holidays = new Date[]{ new Date(1, 1), new Date(3, 3), new Date(1, 5), new Date(6, 5),
                new Date(24, 5), new Date(6, 9), new Date(22, 9), new Date(1, 11),
                new Date(24, 12), new Date(25, 12), new Date(26, 12) };
        return new HashSet<>(Arrays.asList(holidays));
    }
}

class Date {

    private int day;
    private int month;

    Date(int day, int month) {
        this.setDay(day);
        this.setMonth(month);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.day) * 17 + Integer.hashCode(this.month) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }
        Date other = (Date) obj;
        return this.day == other.day && this.month == other.month;
    }

    private void setDay(int day) {
        this.day = day;
    }

    private void setMonth(int month) {
        this.month = month;
    }
}