import java.io.*;
import java.util.*;

public abstract class Book {
    public String title;
    public String dateOfCreation;
    public String language;

    public Book(String title, String dateOfCreation, String language) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.language = language;
    }

    public Book() {}

    public String getTitle() {
        return title;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public String getLanguage() {
        return language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book {" +
                "title = " + title +
                ", dateOfCreation = " + dateOfCreation +
                ", language = " + language +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(dateOfCreation, book.dateOfCreation) && Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, dateOfCreation, language);
    }

    public static void readFile(List<Guide> guides, List<Encyclopedia> encyclopedias) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine().toLowerCase()) {
            case "guide":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        guides.add(new Guide(arrayOfFileLine[0], arrayOfFileLine[1], arrayOfFileLine[2], arrayOfFileLine[3]));
                    }
                }
            case "encyclopedia":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        encyclopedias.add(new Encyclopedia(arrayOfFileLine[0], arrayOfFileLine[1], arrayOfFileLine[2], arrayOfFileLine[3]));
                    }
                }
        }
    }

    public static <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}