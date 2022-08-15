import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.List;

class TrainTest {
    public Train[] trains;

    TrainTest() throws IOException {
        trains = Train.fileReader(5);
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(trains[0].toString(), "Moscow 2341254 12:30 10 10 10 10");
        Assertions.assertEquals(trains[1].toString(), "Moscow 2341255 14:22 15 50 15 10");
        Assertions.assertEquals(trains[2].toString(), "Kursk 2341256 19:50 15 15 15 15");
    }

    @Test
    void destinationTrainsTest() {
        Assertions.assertEquals(Train.destinationTrains(trains, null), List.of());
        Assertions.assertEquals(Train.destinationTrains(null, "Moscow"), List.of());
        Assertions.assertEquals(Train.destinationTrains(trains, ""), List.of());
        Assertions.assertEquals(Train.destinationTrains(trains, "Moscow"), List.of(
                "Moscow 2341254 12:30 10 10 10 10",
                "Moscow 2341255 14:22 15 50 15 10",
                "Moscow 2341258 7:30 10 10 10 10"));
    }

    @Test
    void destinationTrainsAfterInputTimeTest() {
        Assertions.assertEquals(Train.destinationTrainsAfterInputTime(trains, null, 10), List.of());
        Assertions.assertEquals(Train.destinationTrainsAfterInputTime(trains, null, -1), List.of());
        Assertions.assertEquals(Train.destinationTrainsAfterInputTime(null, "Kursk", 0), List.of());
        Assertions.assertEquals(Train.destinationTrainsAfterInputTime(trains, "Moscow", 12), List.of(
                "Moscow 2341254 12:30 10 10 10 10",
                "Moscow 2341255 14:22 15 50 15 10"));
    }

    @Test
    void returnHourTest() {
        Assertions.assertEquals(Train.returnHour(""), 0);
        Assertions.assertEquals(Train.returnHour(null), 0);
        Assertions.assertEquals(Train.returnHour("12:30"), 12);
        Assertions.assertEquals(Train.returnHour("19:01"), 19);
        Assertions.assertEquals(Train.returnHour("23:12"), 23);
    }
}