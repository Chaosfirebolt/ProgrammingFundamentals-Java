package filesExceptions_Lab.oddLines_01;

import java.io.*;

/**
 * Created by ChaosFire on 19.10.2017 г.
 */
public class OddLines {

    private static final String RESOURCE_PATH = "\\resources\\01. Odd Lines\\";

    public static void main(String[] args) throws IOException {
        String projectDir = System.getProperty("user.dir");
        BufferedReader reader = new BufferedReader(new FileReader(projectDir + RESOURCE_PATH + "Input.txt"));
        String line = reader.readLine();
        int count = 0;
        StringBuilder output = new StringBuilder();
        while (line != null) {
            if (count % 2 != 0) {
                output.append(line).append(System.lineSeparator());
            }
            count++;
            line = reader.readLine();
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + RESOURCE_PATH + "Output.txt"));
        writer.write(output.toString().trim());
        writer.close();
    }
}