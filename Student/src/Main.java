import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            countLines = stream.count();
        }

        Student[] students = Student.fileReader(countLines);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input file content:");
        for (Student student: students) {
            System.out.println(student.toString());
        }

        System.out.print("Faculty: ");
        String inputFirstFaculty = scanner.next();
        if (Student.facultyOfStudents(students, inputFirstFaculty).isEmpty()) {
            System.out.println("No Students");
        }
        else {
            Student.print(Student.facultyOfStudents(students, inputFirstFaculty));
        }

        System.out.print("Year: ");
        int inputYear = scanner.nextInt();
        if (Student.studentsAfterInputYear(students, inputYear).isEmpty()) {
            System.out.println("No Students");
        }
        else {
            Student.print(Student.studentsAfterInputYear(students, inputYear));
        }

        System.out.print("Group: ");
        int inputGroup = scanner.nextInt();
        if (Student.groupOfStudents(students, inputGroup).isEmpty()) {
            System.out.println("No Students");
        }
        else {
            Student.print(Student.groupOfStudents(students, inputGroup));
        }

        System.out.print("Faculty: ");
        String inputSecondFaculty = scanner.next();
        System.out.print("Course: ");
        int inputCourse = scanner.nextInt();
        if (Student.studentsFromSameFacultyAndCourse(students, inputSecondFaculty, inputCourse).isEmpty()) {
            System.out.println("No Students");
        }
        else {
            Student.print(Student.studentsFromSameFacultyAndCourse(students, inputSecondFaculty, inputCourse));
        }
    }
}