package conditionalStatementsLoops_Exe.chooseDrink_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class ChooseDrink {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String profession = reader.readLine();
        reader.close();

        switch (profession) {
            case "Athlete":
                System.out.println("Water");
                break;
            case "Businessman":
            case "Businesswoman":
                System.out.println("Coffee");
                break;
            case "SoftUni Student":
                System.out.println("Beer");
                break;
            default:
                System.out.println("Tea");
                break;
        }
    }
}