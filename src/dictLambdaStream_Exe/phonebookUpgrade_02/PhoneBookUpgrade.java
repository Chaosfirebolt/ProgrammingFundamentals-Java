package dictLambdaStream_Exe.phonebookUpgrade_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class PhoneBookUpgrade {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new TreeMap<>();
        StringBuilder output = new StringBuilder();
        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name;
            String phone;
            switch (data[0]) {
                case "A":
                    name = data[1];
                    phone = data[2];
                    phoneBook.put(name, phone);
                    break;
                case "S":
                    name = data[1];
                    phone = phoneBook.get(name);
                    output.append(phone == null ? String.format("Contact %s does not exist.", name) : String.format("%s -> %s", name, phone))
                            .append(System.lineSeparator());
                    break;
                case "ListAll":
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        output.append(String.format("%s -> %s", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    }
                    break;
            }

            input = reader.readLine();
        }
        reader.close();
        System.out.print(output);
    }
}