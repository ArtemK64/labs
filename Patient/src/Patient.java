import java.io.*;
import java.util.*;

public class Patient {
    public long id;
    public String lastName;
    public String firstname;
    public String middleName;
    public String address;
    public String phoneNumber;
    public long medicalRecordNumber;
    public String disease;

    public Patient(long id, String lastName, String firstname, String middleName, String address, String phoneNumber, long medicalRecordNumber, String disease) {
        this.id = id;
        this.lastName = lastName;
        this.firstname = firstname;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalRecordNumber = medicalRecordNumber;
        this.disease = disease;
    }

    public Patient() {}

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstname() {
        return firstname;
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

    public long getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public String getDisease() {
        return disease;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public void setMedicalRecordNumber(long medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return id + " " + lastName + " " + firstname + " " + middleName + " " + address + " " + phoneNumber + " " + medicalRecordNumber + " " + disease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                medicalRecordNumber == patient.medicalRecordNumber &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(firstname, patient.firstname) &&
                Objects.equals(middleName, patient.middleName) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(disease, patient.disease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstname, middleName, address, phoneNumber, medicalRecordNumber, disease);
    }

    public static Patient[] readFile(long lines) throws IOException {
        Patient[] patients = new Patient[(int)lines];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        for (int i = 0; i < lines; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            patients[i] = new Patient(Long.parseLong(line[0]), line[1], line[2], line[3], line[4], line[5], Long.parseLong(line[6]), line[7]);
        }
        return patients;
    }

    public static List<String> sameDisease(Patient[] patients, String disease) { // return list of patients with the same disease
        if (disease == null || disease.isEmpty()) {
            return List.of();
        }
        List<String> patientsList = new ArrayList<>();
        for (Patient patient: patients) {
            if (patient.disease.equals(disease)) {
                patientsList.add(patient.toString());
            }
        }
        return patientsList;
    }

    public static List<String> medicalCardNumberBetweenInterval(Patient[] patients, long startNumber, long endNumber) { // return list of patients which hava medical cards numbers between interval
        if (startNumber < 0 || endNumber < 0) {
            return List.of();
        }
        List<String> patientsList = new ArrayList<>();
        for (Patient patient: patients) {
            if (startNumber < patient.medicalRecordNumber && patient.medicalRecordNumber < endNumber) {
                patientsList.add(patient.toString());
            }
        }
        return patientsList;
    }

    public static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("No patients");
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}
