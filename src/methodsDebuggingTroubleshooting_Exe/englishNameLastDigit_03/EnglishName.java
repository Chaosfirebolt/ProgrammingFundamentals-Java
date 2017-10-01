package methodsDebuggingTroubleshooting_Exe.englishNameLastDigit_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 1.10.2017 г.
 */
public class EnglishName {

    private static String[] names = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        reader.close();
        System.out.println(getName(num));
    }

    private static String getName(String num) {
        int lastDigit = Integer.parseInt(num.substring(num.length() - 1));
        return names[lastDigit];
    }
}