import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.List;

class AbiturientTest {
    public Abiturient[] applicants;

    AbiturientTest() throws IOException {
        applicants = Abiturient.fileReader(7);
    }
    @Test
    void testToString() {
        Assertions.assertEquals(applicants[0].toString(), "18973 Ivanov Ivan Ivanovich Pushkina_80 +79777777777 60 60 70");
        Assertions.assertEquals(applicants[2].toString(), "18975 Sidorov Ivan Ivanovich Pushkina_83 +79777777777 80 80 80");
        Assertions.assertEquals(applicants[6].toString(), "18979 Ivanov Artem Ivanovich Pushkina_81 +79777777777 90 90 90");
    }

    @Test
    void applicantsWithBadPointsTest() {
        Assertions.assertEquals(Abiturient.applicantsWithBadPoints(applicants, -10), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithBadPoints(null, 60), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithBadPoints(applicants, 40), List.of("18978 Artemov Ivan Ivanovich Pushkina_79 +79777777777 39 40 55"));
    }

    @Test
    void checkPointsTest() {
        Assertions.assertTrue(Abiturient.checkPoints(new int[] {60, 60 , 60}, 55));
        Assertions.assertTrue(Abiturient.checkPoints(new int[] {50, 50 , 60}, 50));
        Assertions.assertFalse(Abiturient.checkPoints(new int[] {80, 40 , 100}, 45));
        Assertions.assertFalse(Abiturient.checkPoints(null, 45));
        Assertions.assertFalse(Abiturient.checkPoints(new int[]{}, 45));
    }

    @Test
    void applicantsWithSumOfPointsOverInputTest() {
        Assertions.assertEquals(Abiturient.applicantsWithSumOfPointsOverInput(applicants, 299), List.of("18976 Pechkin Ivan Ivanovich Pushkina_86 +79777777777 100 100 100"));
        Assertions.assertEquals(Abiturient.applicantsWithSumOfPointsOverInput(null, 200), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithSumOfPointsOverInput(applicants, -10), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithSumOfPointsOverInput(applicants, 260), List.of(
                "18976 Pechkin Ivan Ivanovich Pushkina_86 +79777777777 100 100 100",
                "18979 Ivanov Artem Ivanovich Pushkina_81 +79777777777 90 90 90"));
    }

    @Test
    void sumOfPointsTest() {
        Assertions.assertEquals(Abiturient.sumOfPoints(new int[]{}), 0);
        Assertions.assertEquals(Abiturient.sumOfPoints(null), 0);
        Assertions.assertEquals(Abiturient.sumOfPoints(new int[]{60, 60, 60}), 180);
    }

    @Test
    void applicantsWithHighScoreTest() {
        Abiturient.sortPoints(applicants);
        Assertions.assertEquals(Abiturient.applicantsWithHighScore(applicants, -1), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithHighScore(null, 5), List.of());
        Assertions.assertEquals(Abiturient.applicantsWithHighScore(applicants, 1), List.of("18976 Pechkin Ivan Ivanovich Pushkina_86 +79777777777 100 100 100"));
        Assertions.assertEquals(Abiturient.applicantsWithHighScore(applicants, 4), List.of(
                "18976 Pechkin Ivan Ivanovich Pushkina_86 +79777777777 100 100 100",
                "18979 Ivanov Artem Ivanovich Pushkina_81 +79777777777 90 90 90",
                "18975 Sidorov Ivan Ivanovich Pushkina_83 +79777777777 80 80 80",
                "18973 Ivanov Ivan Ivanovich Pushkina_80 +79777777777 60 60 70",
                "18974 Petrov Ivan Ivanovich Pushkina_16 +79777777777 60 60 70",
                "18977 Ivanov Petr Ivanovich Pushkina_70 +79777777777 60 70 60"));
        Assertions.assertEquals(Abiturient.applicantsWithHighScore(applicants, 2), List.of(
                "18976 Pechkin Ivan Ivanovich Pushkina_86 +79777777777 100 100 100",
                "18979 Ivanov Artem Ivanovich Pushkina_81 +79777777777 90 90 90"));
    }
}