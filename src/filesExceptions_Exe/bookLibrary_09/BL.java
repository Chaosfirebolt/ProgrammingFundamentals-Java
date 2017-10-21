package filesExceptions_Exe.bookLibrary_09;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 21.10.2017 г.
 */
public class BL {

    private static final String RES_DIR = "\\resources_Exe\\09_BL";

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Library library = new Library();
        String project = System.getProperty("user.dir");
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                library.getBooks().add(parseInput(reader.readLine().split("\\s+")));
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        library.getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .entrySet()
                .stream()
                .sorted(comparator())
                .forEach(entry -> output.append(String.format("%s -> %.2f", entry.getKey(), totalPrice(entry.getValue())))
                        .append(System.lineSeparator()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static Comparator<Map.Entry<String, List<Book>>> comparator() {
        Comparator<Map.Entry<String, List<Book>>> nameComparator = Comparator.comparing(Map.Entry::getKey);
        Comparator<Map.Entry<String, List<Book>>> totalPriceComparator =
                (e1, e2) -> Double.compare(totalPrice(e2.getValue()), totalPrice(e1.getValue()));
        return totalPriceComparator.thenComparing(nameComparator);
    }

    private static double totalPrice(List<Book> books) {
        return books.stream().mapToDouble(Book::getPrice).sum();
    }

    private static Book parseInput(String[] data) {
        return new Book(data[1], Double.parseDouble(data[5]));
    }
}

class Library {

    private List<Book> books;

    Library() {
        this.setBooks(new ArrayList<>());
    }

    List<Book> getBooks() {
        return this.books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }
}

class Book {

    private String author;
    private double price;

    Book(String author, double price) {
        this.setAuthor(author);
        this.setPrice(price);
    }

    String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}