package examPrep.exam20170226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class HornetComm {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern digitPattern = Pattern.compile("^\\d+$");
        Pattern nonDigitPattern = Pattern.compile("^\\D+$");
        Pattern digitLetterPattern = Pattern.compile("^[a-zA-Z0-9]+$");
        LinkedList<String> broadcasts = new LinkedList<>();
        LinkedList<String> messages = new LinkedList<>();
        while (!input.equals("Hornet is Green")) {
            String[] data = input.split("\\s+<->\\s+");
            if (data.length == 2) {
                boolean digitMatch = digitPattern.matcher(data[0]).find();
                boolean nonDigitMatch = nonDigitPattern.matcher(data[0]).find();
                boolean digitLetterMatch = digitLetterPattern.matcher(data[1]).find();
                if (digitMatch && digitLetterMatch) {
                    messages.addLast(String.format("%s -> %s", reverse(data[0]), data[1]));
                } else if (nonDigitMatch && digitLetterMatch) {
                    broadcasts.addLast(String.format("%s -> %s", reverseCase(data[1]), data[0]));
                }
            }

            input = reader.readLine();
        }
        reader.close();

        System.out.println("Broadcasts:");
        printList(broadcasts);
        System.out.println("Messages:");
        printList(messages);
    }

    private static void printList(LinkedList<String> list) {
        System.out.println(list.size() == 0 ? "None" : String.join(System.lineSeparator(), list));
    }

    private static String reverseCase(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (Character.isUpperCase(character)) {
                result.append(Character.toLowerCase(character));
            } else if (Character.isLowerCase(character)) {
                result.append(Character.toUpperCase(character));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    private static String reverse(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            result.append(string.charAt(i));
        }
        return result.toString();
    }
}