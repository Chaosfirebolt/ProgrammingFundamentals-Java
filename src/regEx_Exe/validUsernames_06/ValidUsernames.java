package regEx_Exe.validUsernames_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class ValidUsernames {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] usernames = reader.readLine().split("[/\\\\ ()]");
        reader.close();
        List<String> valid = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[a-zA-Z]\\w{2,24}$");
        for (String username : usernames) {
            Matcher matcher = pattern.matcher(username);
            if (matcher.find()) {
                valid.add(username);
            }
        }
        printUsernamesHighestSum(valid);
    }

    private static void printUsernamesHighestSum(List<String> valid) {
        String first = "";
        String second = "";
        int sum = 0;
        for (int i = 0; i < valid.size() - 1; i++) {
            int curr = valid.get(i).length() + valid.get(i + 1).length();
            if (curr > sum) {
                sum = curr;
                first = valid.get(i);
                second = valid.get(i + 1);
            }
        }
        System.out.println(first);
        System.out.println(second);
    }
}