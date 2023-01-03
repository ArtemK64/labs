import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Read from file and upload all elements to lists
        List<Helmet> helmetList = new ArrayList<>();
        List<Gloves> glovesList = new ArrayList<>();
        List<Boots> bootsList = new ArrayList<>();
        List<Jumpsuit> jumpsuitList = new ArrayList<>();
        FullEquipment.readFile(helmetList, glovesList, bootsList, jumpsuitList);

        // We can create a new object of FullEquipment class and assign values
        FullEquipment firstFullEquipment = FullEquipment.equipMotorcyclist(helmetList.get(0), glovesList.get(0), bootsList.get(0), jumpsuitList.get(0));
        System.out.println(firstFullEquipment); // result

        System.out.println("\nEquipment price: " + FullEquipment.equipmentPrice(firstFullEquipment));

        System.out.println("\nSort helmets by weight:");
        FullEquipment.print(Helmet.sortByWeight(helmetList));

        System.out.println("\nSort list of gloves by weight:");
        FullEquipment.print(Gloves.sortByWeight(glovesList));

        System.out.println("\nSort list of boots by weight:");
        FullEquipment.print(Boots.sortByWeight(bootsList));

        System.out.println("\nSort jumpsuit by weight:");
        FullEquipment.print(Jumpsuit.sortByWeight(jumpsuitList));

        System.out.println("\nItems in interval of prices:");
        FullEquipment.itemsPriceInterval(firstFullEquipment, 200, 1100); // for example 200 and 1100
    }
}