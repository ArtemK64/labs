import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.*;

class StudentTest {
    Student[] students;

    StudentTest() throws IOException {
        students = Student.fileReader(5);
    }

    @Test
    void ToStringTest() {
        Assertions.assertEquals(students[0].toString(), "89543 Ivan Ivanov Ivanovich 12.12.2002 Puchkina_11 +79777777777 IT 2 201");
        Assertions.assertEquals(students[1].toString(), "89544 Petr Sidorov Petrovich 10.10.2002 Puchkina_10 +79777777777 Economic 2 211");
        Assertions.assertEquals(students[2].toString(), "89545 Ivan Andreev Ivanovich 01.05.2001 Puchkina_1 +79777777777 IT 3 301");
        Assertions.assertEquals(students[3].toString(), "89546 Artem Sidorov Alekseevich 09.11.2002 Puchkina_13 +79777777777 Economic 2 211");
        Assertions.assertEquals(students[4].toString(), "89547 Ivan Penkin Ivanovich 07.06.2002 Puchkina_2 +79777777777 Economic 2 211");
    }

    @Test
    void facultyOfStudentsTest() {
        Assertions.assertEquals(Student.facultyOfStudents(students, "IT"), List.of(
                "89543 Ivan Ivanov Ivanovich 12.12.2002 Puchkina_11 +79777777777 IT 2 201",
                "89545 Ivan Andreev Ivanovich 01.05.2001 Puchkina_1 +79777777777 IT 3 301"));
        Assertions.assertEquals(Student.facultyOfStudents(students, "Physics"), List.of());
        Assertions.assertEquals(Student.facultyOfStudents(students, ""), List.of());
        Assertions.assertEquals(Student.facultyOfStudents(students, null), List.of());
        Assertions.assertEquals(Student.facultyOfStudents(students, "Economic"), List.of(
                "89544 Petr Sidorov Petrovich 10.10.2002 Puchkina_10 +79777777777 Economic 2 211",
                "89546 Artem Sidorov Alekseevich 09.11.2002 Puchkina_13 +79777777777 Economic 2 211",
                "89547 Ivan Penkin Ivanovich 07.06.2002 Puchkina_2 +79777777777 Economic 2 211"));
    }

    @Test
    void studentsAfterInputYearTest() {
        Assertions.assertEquals(Student.studentsAfterInputYear(students, 2003), List.of());
        Assertions.assertEquals(Student.studentsAfterInputYear(students, 2002), List.of());
        Assertions.assertEquals(Student.studentsAfterInputYear(students, -5), List.of());
        Assertions.assertEquals(Student.studentsAfterInputYear(students, 2001), List.of(
                "89543 Ivan Ivanov Ivanovich 12.12.2002 Puchkina_11 +79777777777 IT 2 201",
                "89544 Petr Sidorov Petrovich 10.10.2002 Puchkina_10 +79777777777 Economic 2 211",
                "89546 Artem Sidorov Alekseevich 09.11.2002 Puchkina_13 +79777777777 Economic 2 211",
                "89547 Ivan Penkin Ivanovich 07.06.2002 Puchkina_2 +79777777777 Economic 2 211"));
    }

    @Test
    void groupOfStudentsTest() {
        Assertions.assertEquals(Student.groupOfStudents(students, 200), List.of());
        Assertions.assertEquals(Student.groupOfStudents(students, 201), List.of("89543 Ivan Ivanov Ivanovich 12.12.2002 Puchkina_11 +79777777777 IT 2 201"));
        Assertions.assertEquals(Student.groupOfStudents(students, 301), List.of("89545 Ivan Andreev Ivanovich 01.05.2001 Puchkina_1 +79777777777 IT 3 301"));
        Assertions.assertEquals(Student.groupOfStudents(students, -1), List.of());
    }

    @Test
    void studentsFromSameFacultyAndCourseTest() {
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, "IT", 2), List.of("89543 Ivan Ivanov Ivanovich 12.12.2002 Puchkina_11 +79777777777 IT 2 201"));
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, "Physics", 2), List.of());
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, null, 2), List.of());
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, "IT", -10), List.of());
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, "", 1), List.of());
        Assertions.assertEquals(Student.studentsFromSameFacultyAndCourse(students, "IT", 3), List.of("89545 Ivan Andreev Ivanovich 01.05.2001 Puchkina_1 +79777777777 IT 3 301"));
    }
}