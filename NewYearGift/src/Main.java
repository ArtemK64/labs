import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Marmalade> marmalade = new ArrayList<>();
        List<Lollipop> lollipops = new ArrayList<>();
        List<Toffee> toffees = new ArrayList<>();

        Candy.readFile(marmalade, lollipops, toffees);

        Marmalade.defineWeight(marmalade);
        Lollipop.defineWeight(lollipops);
        Toffee.defineWeight(toffees);

        System.out.println("\n1 present");
        Marmalade.sort(marmalade);

        System.out.println("\n2 present");
        Lollipop.sort(lollipops);

        System.out.println("\n3 present");
        Toffee.sort(toffees);

        System.out.println();
        Marmalade.definePercentOfSugar(marmalade, 40, 50);

        System.out.println();
        Lollipop.definePercentOfSugar(lollipops, 80, 90);

        System.out.println();
        Toffee.definePercentOfSugar(toffees, 50, 60);
    }
}