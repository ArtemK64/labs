import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }
        House[] houses = House.fileReader(countLines);
        Scanner scanner = new Scanner(System.in);

        System.out.println("File content");
        for (House house: houses) {
            System.out.println(house.toString());
        }

        System.out.print("Qty of flats: ");
        int inputQtyOfFlats = scanner.nextInt();
        House.print(House.flatsWithSameRoomsQty(houses, inputQtyOfFlats));

        System.out.print("Qty of flats: ");
        int newInputQtyOfFlats = scanner.nextInt();
        System.out.println("Interval of floor");
        System.out.print("Start: ");
        int inputStart = scanner.nextInt();
        System.out.print("Final: ");
        int inputFinal = scanner.nextInt();
        House.print(House.flatsWithSameRoomsQtyAndIntervalFloor(houses, newInputQtyOfFlats, inputStart, inputFinal));

        System.out.print("Square: ");
        int inputSquare = scanner.nextInt();
        House.print(House.flatsWithOverInputSquare(houses, inputSquare));
    }
}