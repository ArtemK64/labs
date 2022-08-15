import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Guide> guides = new ArrayList<>();
        List<Encyclopedia> encyclopedias = new ArrayList<>();
        Book.readFile(guides, encyclopedias);

        Book.print(guides);
        Book.print(encyclopedias);

        System.out.println();
        Guide guide = new Guide();
        guide.giveBook();
        guide.readBook();
        guide.returnBook();

        System.out.println();
        Encyclopedia encyclopedia = new Encyclopedia();
        encyclopedia.giveBook();
        encyclopedia.readBook();
        encyclopedia.returnBook();
    }
}