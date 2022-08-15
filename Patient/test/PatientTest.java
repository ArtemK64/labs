import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.*;

class PatientTest {
    Patient[] patients;
    PatientTest() throws IOException {
        patients = Patient.readFile(5);
    }

    @Test
    void testToString() {
        Assertions.assertEquals(patients[0].toString(), "14323 Ivanov Ivan Ivanovich Pushkina_40 +79777777777 104 Flu");
        Assertions.assertEquals(patients[1].toString(), "14324 Petrov Ivan Ivanovich Pushkina_12 +79777777777 155 Allergy");
        Assertions.assertEquals(patients[2].toString(), "14325 Sidorov Ivan Petrovich Pushkina_4 +79777777777 109 Flu");
        Assertions.assertEquals(patients[3].toString(), "14326 Pechkin Ivan Ivanovich Pushkina_19 +79777777777 111 Flu");
        Assertions.assertEquals(patients[4].toString(), "14327 Ivanov Petr Ivanovich Pushkina_12 +79777777777 135 Allergy");
    }

    @Test
    void sameDisease() {
        Assertions.assertEquals(Patient.sameDisease(patients, "Allergy"), List.of(
                "14324 Petrov Ivan Ivanovich Pushkina_12 +79777777777 155 Allergy",
                "14327 Ivanov Petr Ivanovich Pushkina_12 +79777777777 135 Allergy"));
        Assertions.assertEquals(Patient.sameDisease(patients, ""), List.of());
        Assertions.assertEquals(Patient.sameDisease(patients, null), List.of());
    }

    @Test
    void medicalCardNumberBetweenInterval() {
        Assertions.assertEquals(Patient.medicalCardNumberBetweenInterval(patients, -1, -1), List.of());
        Assertions.assertEquals(Patient.medicalCardNumberBetweenInterval(patients, 0, 0), List.of());
        Assertions.assertEquals(Patient.medicalCardNumberBetweenInterval(patients, 108, 110), List.of("14325 Sidorov Ivan Petrovich Pushkina_4 +79777777777 109 Flu"));
    }
}