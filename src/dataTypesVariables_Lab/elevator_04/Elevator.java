package dataTypesVariables_Lab.elevator_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class Elevator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(reader.readLine());
        int capacity = Integer.parseInt(reader.readLine());
        reader.close();
        int result = (people / capacity) + (people % capacity == 0 ? 0 : 1);
        System.out.println(result);
    }
}