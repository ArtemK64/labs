import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Computer> computers = new ArrayList<>();
        List<Microwave> microwaves = new ArrayList<>();
        List<TV> tvs = new ArrayList<>();

        Appliances.readFile(computers, microwaves, tvs);

        Appliances.calcPower(computers, microwaves, tvs);

        System.out.println("\nComputers sorted by power:");
        Appliances.print(Computer.sortByPower(computers));

        System.out.println("\nMicrowaves sorted by power:");
        Appliances.print(Microwave.sortByPower(microwaves));

        System.out.println("\nTVs sorted by power:");
        Appliances.print(TV.sortByPower(tvs));

        System.out.println("\nDevices in interval of prices:");
        Appliances.intervalOfPrices(computers, microwaves, tvs, 1000, 2000); // 1000 and 2000 for example

        System.out.println("\nComputers in interval if RAM:");
        Appliances.print(Computer.RAMInterval(computers, 4, 16)); // 4 and 16 for example

        System.out.println("\nMicrowave in interval of volume:");
        Appliances.print(Microwave.intervalOfVolume(microwaves, 14, 20)); // 14 and 20 for example

        System.out.println("\nTVs in interval of diagonals:");
        Appliances.print(TV.intervalOfDiagonals(tvs, 45.5, 65.5));
    }
}