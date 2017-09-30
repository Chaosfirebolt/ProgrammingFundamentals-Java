package dataTypesVariables_Exe.printPartOfASCII_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 30.9.2017 г.
 */
public class PrintPart {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(reader.readLine());
        int end = Integer.parseInt(reader.readLine());
        reader.close();

        StringBuilder output = new StringBuilder();
        output.append((char) start);
        for (int i = start + 1; i <= end; i++) {
            output.append(" ").append((char) i);
        }
        System.out.println(output);
    }
}