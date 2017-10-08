package dictLambdaStream_Exe.phonebook_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChaosFire on 7.10.2017 г.
 */
public class PhoneBook {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new HashMap<>();
        StringBuilder output = new StringBuilder();
        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name = data[1];
            String phone;
            switch (data[0]) {
                case "A":
                    phone = data[2];
                    phoneBook.put(name, phone);
                    break;
                case "S":
                    phone = phoneBook.get(name);
                    output.append(phone == null ? String.format("Contact %s does not exist.", name) : String.format("%s -> %s", name, phone))
                            .append(System.lineSeparator());
                    break;
            }

            input = reader.readLine();
        }
        reader.close();
        System.out.print(output);
    }
}