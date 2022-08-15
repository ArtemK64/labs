import java.io.*;
import java.util.*;

public class Abiturient {
    public long id;
    public String lastName;
    public String firstName;
    public String middleName;
    public String address;
    public String phoneNumber;
    public int[] points;

    public Abiturient(long id, String lastName, String firstName, String middleName, String address, String phoneNumber, int[] points) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }
    public Abiturient() {}

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int[] getPoints() {
        return points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public String toString() {
        return id + " " + lastName + " " + firstName + " " + middleName + " " + address + " " + phoneNumber + " " + Arrays.toString(points).replaceAll("[,\\[\\]]", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abiturient that = (Abiturient) o;
        return id == that.id &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, lastName, firstName, middleName, address, phoneNumber);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    public static Abiturient[] fileReader(long lines) throws IOException {
        Abiturient[] applicants = new Abiturient[(int)lines];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        for (int i = 0; i < lines; i++) {
            String[] arrayOfLine = bufferedReader.readLine().split(" ");
            applicants[i] = new Abiturient(
                    Long.parseLong(arrayOfLine[0]),
                    arrayOfLine[1],
                    arrayOfLine[2],
                    arrayOfLine[3],
                    arrayOfLine[4],
                    arrayOfLine[5],
                    new int[]{Integer.parseInt(arrayOfLine[6]), Integer.parseInt(arrayOfLine[7]), Integer.parseInt(arrayOfLine[8])});
        }
        return applicants;
    }
    public void sortPoints(Abiturient[] applicants) { // sort by points
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < applicants.length - 1; i++) {
                if (sumOfPoints(applicants[i].getPoints()) < sumOfPoints(applicants[i + 1].getPoints())) {
                    Abiturient temp = applicants[i];
                    applicants[i] = applicants[i + 1];
                    applicants[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    public List<String> applicantsWithBadPoints(Abiturient[] applicants, int lowPoint) {
        if (lowPoint < 0 || applicants == null || applicants.length == 0) {
            return List.of();
        }
        List<String> listOfApplicants = new ArrayList<>();
        for (Abiturient abiturient: applicants) {
            if (!checkPoints(abiturient.getPoints(), lowPoint)) {
                listOfApplicants.add(abiturient.toString());
            }
        }
        return listOfApplicants;
    }
    public boolean checkPoints(int[] points, int lowPoint) {
        if (points == null || points.length == 0) {
            return false;
        }
        for (int i: points) {
            if (i < lowPoint) {
                return false;
            }
        }
        return true;
    }
    public List<String> applicantsWithSumOfPointsOverInput(Abiturient[] applicants, int score) {
        if (score < 0 || applicants == null || applicants.length == 0) {
            return List.of();
        }
        List<String> listOfApplicants = new ArrayList<>();
        for (Abiturient abiturient: applicants) {
            if (sumOfPoints(abiturient.getPoints()) > score) {
                listOfApplicants.add(abiturient.toString());
            }
        }
        return listOfApplicants;
    }
    public int sumOfPoints(int[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i: points) {
            sum += i;
        }
        return sum;
    }
    public List<String> applicantsWithHighScore(Abiturient[] applicants, int n) { // return n applicants with high score.
        // If applicant hava the same score with other guy and one of them have enough points to graduate, we will add their too.
        if (n < 0 || applicants == null || applicants.length == 0) {
            return List.of();
        }
        List<String> listOfApplicants = new ArrayList<>();
        for (int i = 0; i < applicants.length; i++) {
            if (i < n || sumOfPoints(applicants[i].getPoints()) == sumOfPoints(applicants[n - 1].getPoints())) {
                listOfApplicants.add(applicants[i].toString());
            }
        }
        return listOfApplicants;
    }
    public void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("No applicants");
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}