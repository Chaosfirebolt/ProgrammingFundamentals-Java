package objectsClasses.dayOfWeek_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ChaosFire on 9.10.2017 г.
 */
public class DayOfWeek {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(reader.readLine());
        dateFormat = new SimpleDateFormat("EEEE");
        System.out.println(dateFormat.format(date));
        reader.close();
    }
}