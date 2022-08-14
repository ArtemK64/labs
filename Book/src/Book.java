import java.io.*;
import java.util.*;

public class Book {
    public long id;
    public String title;
    public String[] authors;
    public String publisher;
    public int publishYear;
    public int qtyOfPages;
    public int price;
    public String typeOfBinding;

    public Book(long id, String title, String[] authors, String publisher, int publishYear, int qtyOfPages, int price, String typeOfBinding) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.qtyOfPages = qtyOfPages;
        this.price = price;
        this.typeOfBinding = typeOfBinding;
    }

    public Book() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getQtyOfPages() {
        return qtyOfPages;
    }

    public int getPrice() {
        return price;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setQtyOfPages(int qtyOfPages) {
        this.qtyOfPages = qtyOfPages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypeOfBinding(String typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    public String toString() {
        return id + " " +
                title + " " +
                Arrays.toString(authors).replaceAll("[,\\[\\]]", "") + " " +
                publisher + " " +
                publishYear + " " +
                qtyOfPages + " " +
                price + " " +
                typeOfBinding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishYear == book.publishYear &&
                qtyOfPages == book.qtyOfPages &&
                price == book.price &&
                Objects.equals(title, book.title) &&
                Arrays.equals(authors, book.authors) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(typeOfBinding, book.typeOfBinding);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, publisher, publishYear, qtyOfPages, price, typeOfBinding);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    public static Book[] fileReader(long lines) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        Book[] books = new Book[(int)lines];
        for (int i = 0; i < lines; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            books[i] = new Book(
                    Long.parseLong(arrayOfFileLine[0]),
                    arrayOfFileLine[1],
                    arrayOfFileLine[2].split("_"),
                    arrayOfFileLine[3],
                    Integer.parseInt(arrayOfFileLine[4]),
                    Integer.parseInt(arrayOfFileLine[5]),
                    Integer.parseInt(arrayOfFileLine[6]),
                    arrayOfFileLine[7]);
        }
        return books;
    }

    public static List<String> authorsBooks(Book[] books, String author) {
        // return list with books from one input author
        if (books == null || books.length == 0 || author == null || author.isEmpty()) {
            return List.of();
        }
        List<String> listOfBooks = new ArrayList<>();
        for (Book book: books) {
            if (checkAuthor(book.getAuthors(), author)) {
                listOfBooks.add(book.toString());
            }
        }
        return listOfBooks;
    }

    public static boolean checkAuthor(String[] authors, String author) {
        if (authors == null || authors.length == 0 || author == null || author.isEmpty()) {
            return false;
        }
        for (String s: authors) {
            if (s.equals(author)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> publisherBook(Book[] books, String publisher) {
        // return list with books from one input publisher
        if (books == null || books.length == 0 || publisher == null || publisher.isEmpty()) {
            return List.of();
        }
        List<String> listOfBooks = new ArrayList<>();
        for (Book book: books) {
            if (book.getPublisher().equals(publisher)) {
                listOfBooks.add(book.toString());
            }
        }
        return listOfBooks;
    }

    public static List<String> publishedAfterInputYear(Book[] books, int year) {
        // books which were published after input year
        if (books == null || books.length == 0 || year < 0) {
            return List.of();
        }
        List<String> listOfBooks = new ArrayList<>();
        for (Book book: books) {
            if (book.getPublishYear() > year) {
                listOfBooks.add(book.toString());
            }
        }
        return listOfBooks;
    }

    public static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}
