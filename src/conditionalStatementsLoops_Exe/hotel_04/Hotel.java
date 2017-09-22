package conditionalStatementsLoops_Exe.hotel_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class Hotel {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        int stay = Integer.parseInt(reader.readLine());
        reader.close();

        double studioPrice = 0;
        double doublePrice = 0;
        double suitePrice = 0;

        switch (month) {
            case "May":
            case "October":
                studioPrice = 50 * stay;
                doublePrice = 65 * stay;
                suitePrice = 75 * stay;
                if (stay > 7) {
                    studioPrice *= 0.95;
                    if (month.equals("October")) {
                        studioPrice -= (0.95 * 50);
                    }
                }
                break;
            case "June":
            case "September":
                studioPrice = 60 * stay;
                doublePrice = 72 * stay;
                suitePrice = 82 * stay;
                if (stay > 7 && month.equals("September")) {
                    studioPrice -= 60;
                }
                if (stay > 14) {
                    doublePrice *= 0.9;
                }
                break;
            case "July":
            case "August":
            case "December":
                studioPrice = 68 * stay;
                doublePrice = 77 * stay;
                suitePrice = 89 * stay;
                if (stay > 14) {
                    suitePrice *= 0.85;
                }
                break;
        }
        System.out.printf("Studio: %.2f lv.\nDouble: %.2f lv.\nSuite: %.2f lv.", studioPrice, doublePrice, suitePrice);
    }
}