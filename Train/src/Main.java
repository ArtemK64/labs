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
        Train[] trains = Train.fileReader(countLines);
        Scanner scanner = new Scanner(System.in);

        System.out.println("File content");
        for (Train train: trains) {
            System.out.println(train.toString());
        }

        System.out.print("Destination: ");
        String inputFirstDestination = scanner.next();
        Train.print(Train.destinationTrains(trains, inputFirstDestination));

        System.out.print("Destination: ");
        String inputSecondDestination = scanner.next();
        System.out.print("Hour: ");
        int inputHour = scanner.nextInt();
        Train.print(Train.destinationTrainsAfterInputTime(trains, inputSecondDestination, inputHour));
    }
}