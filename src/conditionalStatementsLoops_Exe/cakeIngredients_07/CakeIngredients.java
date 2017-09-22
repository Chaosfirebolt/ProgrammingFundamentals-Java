package conditionalStatementsLoops_Exe.cakeIngredients_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class CakeIngredients {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int count = 0;
        while (!input.equals("Bake!")) {
            System.out.printf("Adding ingredient %s.\n", input);
            count++;

            input = reader.readLine();
        }
        reader.close();
        System.out.printf("Preparing cake with %s ingredients.", count);
    }
}