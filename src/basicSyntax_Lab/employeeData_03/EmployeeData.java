package basicSyntax_Lab.employeeData_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by ChaosFire on 18.9.2017 г.
 */
public class EmployeeData {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String age = reader.readLine();
        String id = reader.readLine();
        BigDecimal salary = new BigDecimal(reader.readLine());
        reader.close();
        System.out.printf("Name: %s\nAge: %s\nEmployee ID: %s\nSalary: %.2f", name, age, padLeft(id), salary);
    }

    private static String padLeft(String string) {
        char padChar = '0';
        int desiredLength = 8;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < desiredLength - string.length(); i++) {
            result.append(padChar);
        }
        result.append(string);
        return result.toString();
    }
}