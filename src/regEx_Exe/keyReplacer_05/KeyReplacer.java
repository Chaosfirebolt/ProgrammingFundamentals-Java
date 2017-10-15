package regEx_Exe.keyReplacer_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class KeyReplacer {

    private static final char[] CHARS = new char[]{'|', '<', '\\'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyString = reader.readLine();
        String text = reader.readLine();
        reader.close();

        int[] indexes = indexes(keyString);
        Pattern pattern = Pattern.compile(buildRegex(keyString, indexes));
        Matcher matcher = pattern.matcher(text);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(matcher.group(1));
        }
        System.out.print(output.length() > 0 ? output : "Empty result");
    }

    private static String buildRegex(String keyString, int[] indexes) {
        String start = keyString.substring(0, indexes[0]);
        String end = keyString.substring(indexes[1] + 1);
        return String.format("%s(.*?)%s", start, end);
    }

    private static int[] indexes(String keyString) {
        int[] result = new int[]{-1, -1};
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MIN_VALUE;
        for (char c : CHARS) {
            int index = keyString.indexOf(c);
            if (index > -1) {
                firstIndex = Math.min(firstIndex, index);
            }

            index = keyString.lastIndexOf(c);
            if (index > -1) {
                lastIndex = Math.max(lastIndex, index);
            }
        }
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }
}