package filesExceptions_Exe.advertisementMessage_07;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ChaosFire on 20.10.2017 г.
 */
@SuppressWarnings("Duplicates")
public class AM {

    private static final String RES_DIR = "\\resources_Exe\\07_AM";

    public static void main(String[] args) {
        String project = System.getProperty("user.dir");
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            count = Integer.parseInt(reader.readLine());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static String getRandom(List<String> list, Random rnd) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
        }
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