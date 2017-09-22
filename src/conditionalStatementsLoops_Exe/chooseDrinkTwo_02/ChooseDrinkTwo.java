package conditionalStatementsLoops_Exe.chooseDrinkTwo_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class ChooseDrinkTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String profession = reader.readLine();
        int quantity = Integer.parseInt(reader.readLine());
        reader.close();

        double price;
        switch (profession) {
            case "Athlete":
                price = quantity * 0.7;
                break;
            case "Businessman":
            case "Businesswoman":
                price = quantity * 1.0;
                break;
            case "SoftUni Student":
                price = quantity * 1.7;
                break;
            default:
                price = quantity * 1.2;
                break;
        }
        System.out.printf("The %s has to pay %.2f.", profession, price);
    }
}