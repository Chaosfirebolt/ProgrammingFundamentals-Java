package examPrep.exam_20170709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 28.10.2017 г.
 */
public class RegexMon {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        reader.close();

        Matcher didimon = Pattern.compile("[^a-zA-Z-]+").matcher(text);
        Matcher bojomon = Pattern.compile("[a-zA-Z]+-[a-zA-Z]+").matcher(text);
        StringBuilder output = new StringBuilder();
        int index = 0;
        while (index >= 0) {
            index = match(didimon, index, output);
            if (index < 0) {
                break;
            }
            index = match(bojomon, index, output);
        }
        System.out.print(output);
    }

    private static int match(Matcher matcher, int index, StringBuilder output) {
        if (matcher.find(index)) {
            output.append(matcher.group()).append(System.lineSeparator());
            return matcher.end();
        }
        return -1;
    }
}