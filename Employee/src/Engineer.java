import java.io.*;
import java.util.*;

public class Engineer extends Director implements Employee {
    public String type;

    public Engineer(String firstName, String lastName, String middleName, String department, int yearsOfExperience, String type) {
        super(firstName, lastName, middleName, department, yearsOfExperience);
        this.type = type;
    }

    public Engineer() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engineer {" +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", middleName = " + middleName +
                ", department = " + department +
                ", yearsOfExperience = " + yearsOfExperience +
                ", type = " + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(type, engineer.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    public void fileReader(List<Engineer> engineers, List<Director> directors) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine().toLowerCase()) {
            case "director":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        directors.add(new Director(
                                arrayOfFileLine[0],
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4])));
                    }
                }
            case "engineer":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        engineers.add(new Engineer(
                                arrayOfFileLine[0],
                                arrayOfFileLine[1],
                                arrayOfFileLine[2],
                                arrayOfFileLine[3],
                                Integer.parseInt(arrayOfFileLine[4]),
                                arrayOfFileLine[5]));
                    }
                }
        }
    }

    public void givePromotion() {
        System.out.println("The promotion was given");
    }

    public <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}