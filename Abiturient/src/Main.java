import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }

        Abiturient[] applicants = Abiturient.fileReader(countLines);
        Abiturient abiturient = new Abiturient();

        abiturient.sortPoints(applicants);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Low point: ");
        int inputLowPoint = scanner.nextInt();
        abiturient.print(abiturient.applicantsWithBadPoints(applicants, inputLowPoint));

        System.out.print("Score: ");
        int inputScore = scanner.nextInt();
        abiturient.print(abiturient.applicantsWithSumOfPointsOverInput(applicants, inputScore));

        System.out.print("Vacant places: ");
        int inputQty = scanner.nextInt();
        abiturient.print(abiturient.applicantsWithHighScore(applicants, inputQty));
    }
}