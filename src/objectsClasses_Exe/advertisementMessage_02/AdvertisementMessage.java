package objectsClasses_Exe.advertisementMessage_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class AdvertisementMessage {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        reader.close();

        List<String> phrases = phrases();
        List<String> events = events();
        List<String> authors = authors();
        List<String> cities = cities();

        StringBuilder output = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            output.append(String.format("%s %s %s - %s.",
                    getRandom(phrases, rnd), getRandom(events, rnd), getRandom(authors, rnd), getRandom(cities, rnd)))
                    .append(System.lineSeparator());
        }
        System.out.print(output);
    }

    private static String getRandom(List<String> list, Random rnd) {
        return list.get(rnd.nextInt(list.size()));
    }

    private static List<String> cities() {
        String[] array = new String[]{ "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };
        return new ArrayList<>(Arrays.asList(array));
    }

    private static List<String> authors() {
        String[] array = new String[]{ "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };
        return new ArrayList<>(Arrays.asList(array));
    }

    private static List<String> events() {
        String[] array = new String[]{ "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!" };
        return new ArrayList<>(Arrays.asList(array));
    }

    private static List<String> phrases() {
        String[] array = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        return new ArrayList<>(Arrays.asList(array));
    }
}