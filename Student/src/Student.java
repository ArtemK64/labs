import java.io.*;
import java.util.*;

public class Student {
    public long id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String dateOfBorn;
    public String address;
    public String phoneNumber;
    public String faculty;
    public int course;
    public int group;

    public Student(long id, String firstName, String lastName, String middleName, String dateOfBorn, String address, String phoneNumber, String faculty, int course, int group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBorn = dateOfBorn;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student() {}

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBorn() {
        return dateOfBorn;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDateOfBorn(String dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return id + " " +
                firstName + " " +
                lastName + " " +
                middleName + " " +
                dateOfBorn + " " +
                address + " " +
                phoneNumber + " " +
                faculty + " " +
                course + " " +
                group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                course == student.course &&
                group == student.group &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(middleName, student.middleName) &&
                Objects.equals(dateOfBorn, student.dateOfBorn) &&
                Objects.equals(address, student.address) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, dateOfBorn, address, phoneNumber, faculty, course, group);
    }

    public static Student[] fileReader(long lines) throws IOException { // upload content from file to array of Students
        Student[] students = new Student[(int)lines];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        for (int i = 0; i < lines; i++) {
            String[] arrayOfLine = bufferedReader.readLine().split(" ");
            students[i] = new Student(
                    Integer.parseInt(arrayOfLine[0]),
                    arrayOfLine[1],
                    arrayOfLine[2],
                    arrayOfLine[3],
                    arrayOfLine[4],
                    arrayOfLine[5],
                    arrayOfLine[6],
                    arrayOfLine[7],
                    Integer.parseInt(arrayOfLine[8]),
                    Integer.parseInt(arrayOfLine[9]));
        }
        bufferedReader.close();
        return students;
    }

    public static List<String> facultyOfStudents(Student[] students, String faculty) { // return the list of students which study at the same faculty
        if (faculty == null || faculty.isEmpty()) {
            return List.of();
        }
        List<String> listOfStudents = new ArrayList<>();
        for (Student student: students) {
            if (student.faculty.equals(faculty)) {
                listOfStudents.add(student.toString());
            }
        }
        return listOfStudents;
    }

    public static List<String> studentsAfterInputYear(Student[] students, int year) { // return the list of students which were born after input year
        if (year < 0) {
            return List.of();
        }
        List<String> listOfStudents = new ArrayList<>();
        for (Student student: students) {
            String[] splitOfDate = student.dateOfBorn.split("\\.");
            if (Integer.parseInt(splitOfDate[2]) > year) {
                listOfStudents.add(student.toString());
            }
        }
        return listOfStudents;
    }

    public static List<String> groupOfStudents(Student[] students, int group) { // return the list of students which study at the same group
        if (group < 0) {
            return List.of();
        }
        List<String> listOfStudents = new ArrayList<>();
        for (Student student: students) {
            if (student.group == group) {
                listOfStudents.add(student.toString());
            }
        }
        return listOfStudents;
    }

    public static List<String> studentsFromSameFacultyAndCourse(Student[] students, String faculty, int course) { // return the list of students which study at the same faculty and course
        if (faculty == null || faculty.isEmpty() || course < 0 || course > 6) {
            return List.of();
        }
        List<String> listOfStudents = new ArrayList<>();
        for (Student student: students) {
            if (student.course == course && student.faculty.equals(faculty)) {
                listOfStudents.add(student.toString());
            }
        }
        return listOfStudents;
    }

    public static void print(List<String> resultList) {
        for (String s: resultList) {
            System.out.println(s);
        }
    }
}