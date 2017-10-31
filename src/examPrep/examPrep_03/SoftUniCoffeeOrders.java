package examPrep.examPrep_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ChaosFire on 30.10.2017 г.
 */
public class SoftUniCoffeeOrders {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int orderCount = Integer.parseInt(reader.readLine());
        BigDecimal total = BigDecimal.ZERO;
        StringBuilder output = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < orderCount; i++) {
            BigDecimal price = new BigDecimal(reader.readLine());
            calendar.setTime(parseDate(reader.readLine()));
            int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            BigDecimal capsuleCount = new BigDecimal(reader.readLine());
            BigDecimal currPrice = price.multiply(new BigDecimal(days)).multiply(capsuleCount);
            total = total.add(currPrice);
            output.append(String.format("The price for the coffee is: $%.2f", currPrice)).append(System.lineSeparator());
        }
        reader.close();
        output.append(String.format("Total: $%.2f", total));
        System.out.print(output);
    }

    private static Date parseDate(String dateString) throws ParseException {
        final String delimiter = "/";
        String[] data = dateString.split(delimiter);
        for (int i = 0; i <= 1; i++) {
            data[i] = padLeftZero(data[i]);
        }
        return DATE_FORMAT.parse(String.join(delimiter, data));
    }

    private static String padLeftZero(String string) {
        return string.length() == 1 ? "0" + string : string;
    }
}