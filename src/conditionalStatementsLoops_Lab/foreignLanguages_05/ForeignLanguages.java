package conditionalStatementsLoops_Lab.foreignLanguages_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 21.9.2017 г.
 */
public class ForeignLanguages {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();
        reader.close();
        if (country.equals("USA") || country.equals("England")) {
            System.out.println("English");
        } else if (country.equals("Spain") || country.equals("Argentina") || country.equals("Mexico")) {
            System.out.println("Spanish");
        } else {
            System.out.println("unknown");
        }
    }
}