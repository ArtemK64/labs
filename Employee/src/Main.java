import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Engineer> engineers = new ArrayList<>();
        List<Director> directors = new ArrayList<>();

        Engineer engineer = new Engineer();
        engineer.fileReader(engineers, directors);
        engineer.print(engineers);
        engineer.print(directors);

        System.out.println();
        engineer.givePromotion();
    }
}