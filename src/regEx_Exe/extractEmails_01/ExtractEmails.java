package regEx_Exe.extractEmails_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class ExtractEmails {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        reader.close();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+[a-zA-Z0-9._-]*[a-zA-Z0-9]*@[a-zA-Z]+[a-zA-Z-]*[a-zA-Z]+(\\.[a-zA-Z]+[a-zA-Z-]*[a-zA-Z]+)+");
        Matcher matcher = pattern.matcher(text);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            int prevIndex = matcher.start() - 1;
            if (prevIndex >= 0 && (text.charAt(prevIndex) == '.' || text.charAt(prevIndex) == '-' || text.charAt(prevIndex) == '_')) {
                continue;
            }
            output.append(matcher.group()).append(System.lineSeparator());
        }
        System.out.print(output);
    }
}