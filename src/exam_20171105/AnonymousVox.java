package exam_20171105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 5.11.2017 г.
 */
public class AnonymousVox {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Matcher textMatcher = Pattern.compile("([a-zA-Z]+)(.+)(\\1)").matcher(text);
        Matcher valuesMatcher = Pattern.compile("\\{([^{}]+)}").matcher(reader.readLine());
        reader.close();
        while (textMatcher.find()) {
            StringBuilder replacement = new StringBuilder();
            replacement.append(textMatcher.group(1));
            if (valuesMatcher.find()) {
                replacement.append(valuesMatcher.group(1));
            } else {
                replacement.append(textMatcher.group(2));
            }
            replacement.append(textMatcher.group(3));

            text = text.replace(textMatcher.group(), replacement);
        }
        System.out.print(text);
    }
}