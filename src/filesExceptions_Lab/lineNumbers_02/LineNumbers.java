package filesExceptions_Lab.lineNumbers_02;

import java.io.*;

/**
 * Created by ChaosFire on 19.10.2017 г.
 */
public class LineNumbers {

    private static final String RESOURCE_PATH = "\\resources\\02. Line Numbers\\";

    public static void main(String[] args) throws IOException {
        String projectDir = System.getProperty("user.dir");
        BufferedReader reader = new BufferedReader(new FileReader(projectDir + RESOURCE_PATH + "Input.txt"));
        StringBuilder output = new StringBuilder();
        String line = reader.readLine();
        int count = 1;
        while (line != null) {
            output.append(count).append(". ").append(line).append(System.lineSeparator());
            count++;
            line = reader.readLine();
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + RESOURCE_PATH + "Output.txt"));
        writer.write(output.toString().trim());
        writer.close();
    }
}