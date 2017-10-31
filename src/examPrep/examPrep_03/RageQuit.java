package examPrep.examPrep_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 31.10.2017 г.
 */
public class RageQuit {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([^\\d]+)(\\d+)");
        Matcher matcher = pattern.matcher(reader.readLine());
        reader.close();

        Set<Character> unique = new HashSet<>();
        StringBuilder rage = new StringBuilder();
        while (matcher.find()) {
            String string = matcher.group(1).toUpperCase();
            int count = Integer.parseInt(matcher.group(2));

            if (count > 0) {
                for (int i = 0; i < string.length(); i++) {
                    unique.add(string.charAt(i));
                }
                for (int i = 0; i < count; i++) {
                    rage.append(string);
                }
            }
        }
        System.out.println(String.format("Unique symbols used: %d", unique.size()));
        System.out.print(rage);
    }
}