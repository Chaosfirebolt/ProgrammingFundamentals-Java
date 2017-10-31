package examPrep.exam_20170709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class PokeMon {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pokePower = Integer.parseInt(reader.readLine());
        int distance = Integer.parseInt(reader.readLine());
        int exhaustionFactor = Integer.parseInt(reader.readLine());
        reader.close();
        int pokeTargets = 0;
        double half = pokePower / 2.0;
        while (pokePower >= distance) {
            pokeTargets++;

            pokePower -= distance;
            if (pokePower == half && exhaustionFactor != 0) {
                pokePower /= exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(pokeTargets);
    }
}