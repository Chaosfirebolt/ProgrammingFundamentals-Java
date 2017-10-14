package regEx_Lab.replaceTag_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 14.10.2017 г.
 */
public class ReplaceTag {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();
        while (!input.equals("end")) {
            sb.append(input).append(System.lineSeparator());
            input = reader.readLine();
        }
        reader.close();

        String text = sb.toString();
        Pattern pattern = Pattern.compile("<a(.+?)>(.+?)</a>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = text.replace(matcher.group(), replacement(matcher.group(1), matcher.group(2)));
        }
        System.out.println(text);
    }

    private static String replacement(String href, String val) {
        return String.format("[URL%s]%s[/URL]", href, val);
    }
}