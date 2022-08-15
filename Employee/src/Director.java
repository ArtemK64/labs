import java.util.*;

public class Director {
    public String firstName;
    public String lastName;
    public String middleName;
    public String department;
    public int yearsOfExperience;

    public Director (String firstName, String lastName, String middleName, String department, int yearsOfExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Director() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
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

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Director {" +
                "firstName = " + firstName +
                ", lastName = " + lastName +
                ", middleName = " + middleName +
                ", department = " + department +
                ", yearsOfExperience = " + yearsOfExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return yearsOfExperience == director.yearsOfExperience && Objects.equals(firstName, director.firstName) && Objects.equals(lastName, director.lastName) && Objects.equals(middleName, director.middleName) && Objects.equals(department, director.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, department, yearsOfExperience);
    }
}