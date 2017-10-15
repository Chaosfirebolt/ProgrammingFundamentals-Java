package regEx_Exe.cameraView_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class CameraView {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] quantifiers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String view = reader.readLine();
        reader.close();
        System.out.print(capture(view, quantifiers[0], quantifiers[1]));
    }

    private static String capture(String view, int skip, int take) {
        String regex = String.format("\\|<([^|<]{0,%d})([^|<]{0,%d})", skip, take);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(view);
        LinkedList<String> shots = new LinkedList<>();
        while (matcher.find()) {
            shots.addLast(matcher.group(2));
        }
        return String.join(", ", shots);
    }
}