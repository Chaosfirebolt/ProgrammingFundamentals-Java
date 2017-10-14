package regEx_Lab.matchHexadecimalNumbers_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class MatchHex {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("(0x|\\b)[0-9A-F]+\\b");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(matcher.group()).append(" ");
        }
        System.out.print(output);
    }
}