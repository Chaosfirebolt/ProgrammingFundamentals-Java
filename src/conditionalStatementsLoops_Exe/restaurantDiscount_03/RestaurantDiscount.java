package conditionalStatementsLoops_Exe.restaurantDiscount_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class RestaurantDiscount {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int groupSize = Integer.parseInt(reader.readLine());
        String pack = reader.readLine();
        reader.close();

        double price;
        String hall;
        if (groupSize <= 50) {
            price = 2500;
            hall = "Small Hall";
        } else if (groupSize <= 100) {
            price = 5000;
            hall = "Terrace";
        } else if (groupSize <= 120) {
            price = 7500;
            hall = "Great Hall";
        } else {
            System.out.println("We do not have an appropriate hall.");
            return;
        }

        switch (pack) {
            case "Normal":
                price += 500;
                price *= 0.95;
                break;
            case "Gold":
                price += 750;
                price *= 0.9;
                break;
            case "Platinum":
                price += 1000;
                price *= 0.85;
                break;
        }

        System.out.printf("We can offer you the %s\nThe price per person is %.2f$", hall, price / groupSize);
    }
}