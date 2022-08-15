import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }

        Patient[] patients = Patient.readFile(countLines);
        System.out.println("File content: ");
        for (Patient patient: patients) {
            System.out.println(patient.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Disease: ");
        String inputDisease = scanner.next();
        Patient.print(Patient.sameDisease(patients, inputDisease));

        System.out.println("Interval");
        System.out.print("A: ");
        long inputA = scanner.nextLong();
        System.out.print("B: ");
        long inputB = scanner.nextLong();
        Patient.print(Patient.medicalCardNumberBetweenInterval(patients, inputA, inputB));
    }
}