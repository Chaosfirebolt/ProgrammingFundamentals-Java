package conditionalStatementsLoops_Lab.monthPrinter_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class MonthPrinter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        reader.close();
        if (month < 1 || month > 12) {
            System.out.println("Error!");
        } else {
            System.out.println(months[month - 1]);
        }
    }
}