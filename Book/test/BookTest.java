import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.List;

class BookTest {
    public Book[] books;

    BookTest() throws IOException {
        books = Book.fileReader(6);
    }

    @Test
    void testToString() {
        Assertions.assertEquals(books[0].toString(), "98472 Finance Ivanov.I.I Petrov.I.I Flower 2000 354 300 Hardcover");
        Assertions.assertEquals(books[1].toString(), "98473 Economics Petrov.I.I Sidorov.I.I Rose 2005 690 450 Hardcover");
        Assertions.assertEquals(books[2].toString(), "98474 Self-development Petrov.I.P Rose 2002 354 250 Hardcover");
    }

    @Test
    void testAuthorsBooks() {
        Assertions.assertEquals(Book.authorsBooks(books, null), List.of());
        Assertions.assertEquals(Book.authorsBooks(books, ""), List.of());
        Assertions.assertEquals(Book.authorsBooks(null, "Sidorov.I.I"), List.of());
        Assertions.assertEquals(Book.authorsBooks(books, "Pushkin.A.S"), List.of());
        Assertions.assertEquals(Book.authorsBooks(books, "Sidorov.I.I"), List.of(
                "98473 Economics Petrov.I.I Sidorov.I.I Rose 2005 690 450 Hardcover",
                "98475 Physics Ivanov.P.I Sidorov.I.I Flower 2003 354 660 Hardcover",
                "98476 Finance Sidorov.I.I Flower 2005 290 120 Hardcover"));
    }

    @Test
    void testCheckAuthor() {
        Assertions.assertFalse(Book.checkAuthor(null, "Sidorov.I.I"));
        Assertions.assertFalse(Book.checkAuthor(null, null));
        Assertions.assertFalse(Book.checkAuthor(null, ""));
        Assertions.assertTrue(Book.checkAuthor(new String[]{"Petrov.I.I", "Sidorov.I.I"}, "Petrov.I.I"));
        Assertions.assertTrue(Book.checkAuthor(new String[]{"Sidorov.I.I"}, "Sidorov.I.I"));
    }

    @Test
    void testPublisherBook() {
        Assertions.assertEquals(Book.publisherBook(books, ""), List.of());
        Assertions.assertEquals(Book.publisherBook(books, null), List.of());
        Assertions.assertEquals(Book.publisherBook(null, ""), List.of());
        Assertions.assertEquals(Book.publisherBook(books, "Rose"), List.of(
                "98473 Economics Petrov.I.I Sidorov.I.I Rose 2005 690 450 Hardcover",
                "98474 Self-development Petrov.I.P Rose 2002 354 250 Hardcover",
                "98477 Self-development Sidorov.P.P Rose 2010 780 560 Hardcover"));
    }

    @Test
    void testPublishedAfterInputYear() {
        Assertions.assertEquals(Book.publishedAfterInputYear(books, -1), List.of());
        Assertions.assertEquals(Book.publishedAfterInputYear(null, 2002), List.of());
        Assertions.assertEquals(Book.publishedAfterInputYear(books, 2009), List.of(
                "98477 Self-development Sidorov.P.P Rose 2010 780 560 Hardcover"));
    }
}