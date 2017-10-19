package filesExceptions_Lab.wordCount_03;

import java.io.*;
import java.util.*;

/**
 * Created by ChaosFire on 19.10.2017 г.
 */
public class WordCount {

    private static final String RESOURCE_PATH = "\\resources\\03. Word Count\\";

    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        Map<String, Integer> words = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(projectDir + RESOURCE_PATH + "words.txt"))) {
            String[] input = reader.readLine().toLowerCase().split("\\s+");
            for (String word : input) {
                words.put(word, 0);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        List<String> allWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(projectDir + RESOURCE_PATH + "text.txt"))) {
            String input = reader.readLine();
            while (input != null) {
                allWords.addAll(Arrays.asList(input.toLowerCase().split("\\b+")));
                input = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        for (String word : allWords) {
            Integer count = words.get(word);
            if (count != null) {
                words.replace(word, count + 1);
            }
        }
        StringBuilder output = new StringBuilder();
        words.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> output.append(entry.getKey()).append(" - ").append(entry.getValue()).append(System.lineSeparator()));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(projectDir + RESOURCE_PATH + "Output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}