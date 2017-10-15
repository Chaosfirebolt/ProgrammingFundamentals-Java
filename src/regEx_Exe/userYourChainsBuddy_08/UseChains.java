package regEx_Exe.userYourChainsBuddy_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class UseChains {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> values = extractValues(reader.readLine());
        reader.close();
        String manual = decodeManual(values);
        System.out.print(manual);
    }

    private static String decodeManual(LinkedList<String> values) {
        StringBuilder decoded = new StringBuilder();
        for (String value : values) {
            String temp = decodeSpaces(value);
            for (int i = 0; i < temp.length(); i++) {
                char character = temp.charAt(i);
                if (character >= 97 && character <= 109) {
                    character = (char) (character + 13);
                } else if (character >= 110 && character <= 122) {
                    character = (char) (character - 13);
                }
                decoded.append(character);
            }
        }
        return decoded.toString();
    }

    private static LinkedList<String> extractValues(String input) {
        LinkedList<String> result = new LinkedList<>();
        Pattern pattern = Pattern.compile("<p>(.+?)</p>");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result.addLast(matcher.group(1));
        }
        return result;
    }

    private static String decodeSpaces(String string) {
        final String replacement = " ";
        String temp = string.replaceAll("[^a-z0-9]", replacement);
        return temp.replaceAll("\\s+", replacement);
    }
}