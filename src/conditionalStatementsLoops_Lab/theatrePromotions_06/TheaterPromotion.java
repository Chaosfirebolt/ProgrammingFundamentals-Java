package conditionalStatementsLoops_Lab.theatrePromotions_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class TheaterPromotion {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        reader.close();

        switch (day) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    System.out.println("12$");
                } else if (age > 18 && age <= 64) {
                    System.out.println("18$");
                } else if (age > 64 && age <= 122) {
                    System.out.println("12$");
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    System.out.println("15$");
                } else if (age > 18 && age <= 64) {
                    System.out.println("20$");
                } else if (age > 64 && age <= 122) {
                    System.out.println("15$");
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    System.out.println("5$");
                } else if (age > 18 && age <= 64) {
                    System.out.println("12$");
                } else if (age > 64 && age <= 122) {
                    System.out.println("10$");
                } else {
                    System.out.println("Error!");
                }
                break;
        }
    }
}