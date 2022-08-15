import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.*;

class HouseTest {
    public House[] houses;

    HouseTest() throws IOException {
        houses = House.fileReader(7);
    }

    @Test
    void testToString() {
        Assertions.assertEquals(houses[0].toString(), "23454 1 60 6 3 Pushkina_10 Sectional 10");
        Assertions.assertEquals(houses[1].toString(), "23455 11 45 6 3 Pushkina_19 Sectional 8");
        Assertions.assertEquals(houses[2].toString(), "23456 38 90 6 3 Pushkina_71 Sectional 3");
    }

    @Test
    void flatsWithSameRoomsQty() {
        Assertions.assertEquals(House.flatsWithSameRoomsQty(houses, -1), List.of());
        Assertions.assertEquals(House.flatsWithSameRoomsQty(null, 2), List.of());
        Assertions.assertEquals(House.flatsWithSameRoomsQty(houses, 4), List.of(
                "23458 14 80 6 4 Pushkina_90 Sectional 9",
                "23459 54 60 5 4 Pushkina_17 Sectional 5",
                "23460 12 90 5 4 Pushkina_98 Sectional 7"));
    }

    @Test
    void flatsWithSameRoomsQtyAndIntervalFloor() {
        Assertions.assertEquals(House.flatsWithSameRoomsQtyAndIntervalFloor(houses, 4, 5, 6), List.of(
                "23458 14 80 6 4 Pushkina_90 Sectional 9",
                "23459 54 60 5 4 Pushkina_17 Sectional 5",
                "23460 12 90 5 4 Pushkina_98 Sectional 7"));
        Assertions.assertEquals(House.flatsWithSameRoomsQtyAndIntervalFloor(houses, 4, 1, 10), List.of(
                "23458 14 80 6 4 Pushkina_90 Sectional 9",
                "23459 54 60 5 4 Pushkina_17 Sectional 5",
                "23460 12 90 5 4 Pushkina_98 Sectional 7"));
        Assertions.assertEquals(House.flatsWithSameRoomsQtyAndIntervalFloor(houses, -1, -1, -1), List.of());
        Assertions.assertEquals(House.flatsWithSameRoomsQtyAndIntervalFloor(null, 4, 1, 5), List.of());
    }

    @Test
    void flatsWithOverInputSquare() {
        Assertions.assertEquals(House.flatsWithOverInputSquare(houses, -1), List.of());
        Assertions.assertEquals(House.flatsWithOverInputSquare(null, 80), List.of());
        Assertions.assertEquals(House.flatsWithOverInputSquare(houses, 80), List.of(
                "23456 38 90 6 3 Pushkina_71 Sectional 3",
                "23460 12 90 5 4 Pushkina_98 Sectional 7"));
    }
}