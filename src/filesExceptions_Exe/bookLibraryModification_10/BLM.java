package filesExceptions_Exe.bookLibraryModification_10;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by ChaosFire on 21.10.2017 г.
 */
public class BLM {

    private static final String RES_DIR = "\\resources_Exe\\10_BLM";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Library library = new Library();
        Date date = null;
        String project = System.getProperty("user.dir");
        try (BufferedReader reader = new BufferedReader(new FileReader(project + RES_DIR + "\\input.txt"))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                library.getBooks().add(parseBook(reader.readLine().split("\\s+")));
            }
            date = parseDate(reader.readLine());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        Date finalDate = date;
        library.getBooks()
                .stream()
                .filter(b -> finalDate == null || b.getReleaseDate().after(finalDate))
                .sorted(comparator())
                .forEach(b -> output.append(String.format("%s -> %s", b.getTitle(), DATE_FORMAT.format(b.getReleaseDate())))
                        .append(System.lineSeparator()));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(project + RES_DIR + "\\output.txt"))) {
            writer.write(output.toString().trim());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static Comparator<Book> comparator() {
        Comparator<Book> dateComparator = Comparator.comparing(Book::getReleaseDate);
        Comparator<Book> titleComparator = Comparator.comparing(Book::getTitle);
        return dateComparator.thenComparing(titleComparator);
    }

    private static Book parseBook(String[] input) {
        return new Book(input[0], parseDate(input[3]));
    }

    private static Date parseDate(String input) {
        Date date;
        try {
            date = DATE_FORMAT.parse(input);
        } catch (ParseException exc) {
            date = null;
        }
        return date;
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

    private String title;
    private Date releaseDate;

    Book(String title, Date releaseDate) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
    }

    String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    Date getReleaseDate() {
        return this.releaseDate;
    }

    private void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}