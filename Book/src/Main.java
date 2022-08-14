import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }
        Book[] books = Book.fileReader(countLines);
        System.out.println("File content");
        for (Book book: books) {
            System.out.println(book.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        String inputString = scanner.next();
        Book.print(Book.authorsBooks(books, inputString));

        System.out.print("Publisher: ");
        String inputPublisher = scanner.next();
        Book.print(Book.publisherBook(books, inputPublisher));

        System.out.print("Year: ");
        int inputYear = scanner.nextInt();
        Book.print(Book.publishedAfterInputYear(books, inputYear));
    }
}