package dataTypesVariables_Lab.triples_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChaosFire on 28.9.2017 г.
 */
public class Triples {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        char a = 'a';
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    output.append((char) (a + i)).append((char) (a + j)).append((char) (a + k)).append(System.lineSeparator());
                }
            }
        }
        System.out.print(output);
    }
}