package regEx_Lab.matchPhoneNumber_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class MatchPhoneNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("( |^)(\\+359([ -])2\\3\\d{3}\\3\\d{4})\\b");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(matcher.group(2)).append(", ");
        }
        if (output.length() > 0) {
            output.delete(output.length() - 2, output.length());
        }
        System.out.print(output);
    }
}