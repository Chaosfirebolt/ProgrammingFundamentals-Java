package conditionalStatementsLoops_Exe.neighbourWars_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 22.9.2017 г.
 */
public class NeighbourWars {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int peshoDmg = Integer.parseInt(reader.readLine());
        int goshoDmg = Integer.parseInt(reader.readLine());
        reader.close();

        int pesho = 100;
        int gosho = 100;
        int round = 0;
        String winner = "";
        while (true) {
            round++;
            if (round % 2 != 0) {
                gosho -= peshoDmg;
                if (gosho <= 0) {
                    winner = "Pesho";
                    break;
                }
                System.out.printf("Pesho used Roundhouse kick and reduced Gosho to %d health.\n", gosho);
            } else {
                pesho -= goshoDmg;
                if (pesho <= 0) {
                    winner = "Gosho";
                    break;
                }
                System.out.printf("Gosho used Thunderous fist and reduced Pesho to %d health.\n", pesho);
            }
            if (round % 3 == 0) {
                pesho += 10;
                gosho += 10;
            }
        }
        System.out.printf("%s won in %dth round.", winner, round);
    }
}