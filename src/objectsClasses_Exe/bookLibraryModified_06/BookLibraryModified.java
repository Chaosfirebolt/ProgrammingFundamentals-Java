package objectsClasses_Exe.bookLibraryModified_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by ChaosFire on 11.10.2017 г.
 */
public class BookLibraryModified {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Library library = new Library();
        for (int i = 0; i < count; i++) {
            library.getBooks().add(parseBook(reader.readLine().split("\\s+")));
        }
        Date date = parseDate(reader.readLine());
        reader.close();

        StringBuilder output = new StringBuilder();
        library.getBooks()
                .stream()
                .filter(b -> b.getReleaseDate().after(date))
                .sorted(comparator())
                .forEach(b -> output.append(String.format("%s -> %s", b.getTitle(), DATE_FORMAT.format(b.getReleaseDate())))
                        .append(System.lineSeparator()));
        System.out.print(output);
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