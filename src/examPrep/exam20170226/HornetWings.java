package examPrep.exam20170226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class HornetWings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int flaps = Integer.parseInt(reader.readLine());
        double distance = Double.parseDouble(reader.readLine());
        int endurance = Integer.parseInt(reader.readLine());
        reader.close();

        double traveled = distance / 1000 * flaps;
        int time = flaps / 100;
        time += flaps / endurance * 5;
        System.out.println(String.format("%.2f m.", traveled));
        System.out.print(String.format("%d s.", time));
    }
}