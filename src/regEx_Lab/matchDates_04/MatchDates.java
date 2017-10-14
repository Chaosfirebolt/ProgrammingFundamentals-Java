package regEx_Lab.matchDates_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class MatchDates {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})([.\\-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(String.format("Day: %s, Month: %s, Year: %s",
                    matcher.group("day"), matcher.group("month"), matcher.group("year")))
                    .append(System.lineSeparator());
        }
        System.out.print(output);
    }
}