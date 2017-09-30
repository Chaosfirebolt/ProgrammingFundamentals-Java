package dataTypesVariables_Exe.fastPrimeCheckerRefactor_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class PrimeChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lastNumber = Integer.parseInt(reader.readLine());
        reader.close();

        for (int currNumber = 2; currNumber <= lastNumber; currNumber++) {
            boolean isPrime = true;
            int lastCheck = (int) Math.sqrt(currNumber);
            for (int checker = 2; checker <= lastCheck; checker++) {
                if  (currNumber % checker == 0) {
                    isPrime = false;
                    break;
                }
            }
            String prime = Boolean.toString(isPrime);
            System.out.printf("%d -> %s\r\n", currNumber, prime.substring(0, 1).toUpperCase() + prime.substring(1));
        }
    }
}