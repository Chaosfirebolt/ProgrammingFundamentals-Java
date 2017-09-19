package basicSyntax_Exe.characterStats_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 19.9.2017 г.
 */
public class CharacterStats {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int currHealth = Integer.parseInt(reader.readLine());
        int maxHealth = Integer.parseInt(reader.readLine());
        int currEnergy = Integer.parseInt(reader.readLine());
        int maxEnergy = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.printf("Name: %s\n", name);
        System.out.printf("Health: %s\n", bar(currHealth, maxHealth));
        System.out.printf("Energy: %s", bar(currEnergy, maxEnergy));
    }

    private static String bar(int curr, int max) {
        StringBuilder output = new StringBuilder("|");
        for (int i = 0; i < curr; i++) {
            output.append('|');
        }
        for (int i = 0; i < max - curr; i++) {
            output.append('.');
        }
        output.append('|');
        return output.toString();
    }
}