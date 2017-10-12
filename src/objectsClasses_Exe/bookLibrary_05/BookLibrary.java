package objectsClasses_Exe.bookLibrary_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 10.10.2017 г.
 */
public class BookLibrary {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Library library = new Library();
        for (int i = 0; i < count; i++) {
            library.getBooks().add(parseInput(reader.readLine().split("\\s+")));
        }
        reader.close();

        StringBuilder output = new StringBuilder();
        library.getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .entrySet()
                .stream()
                .sorted(comparator())
                .forEach(entry -> output.append(String.format("%s -> %.2f", entry.getKey(), totalPrice(entry.getValue())))
                        .append(System.lineSeparator()));
        System.out.print(output);
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