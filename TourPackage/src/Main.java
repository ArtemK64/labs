import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Sports> sportsList = new ArrayList<>();
        List<Shopping> shoppingList = new ArrayList<>();
        List<Cruise> cruiseList = new ArrayList<>();
        List<Excursion> excursionList = new ArrayList<>();
        List<Vacation> vacationList = new ArrayList<>();

        GenerateTour generateTour = GenerateTour.readFile(sportsList, shoppingList, cruiseList, excursionList, vacationList);

        GenerateTour.generateVariationsForClient(generateTour);
    }
}