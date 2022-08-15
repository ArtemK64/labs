import java.io.*;
import java.util.*;

public class House {
    public long id;
    public int flatNumber;
    public int square;
    public int floor;
    public int roomsQty;
    public String street;
    public String typeOfBuilding;
    public int yearsOfExploitation;

    public House(long id, int flatNumber, int square, int floor, int roomsQty, String street, String typeOfBuilding, int yearsOfExploitation) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.square = square;
        this.floor = floor;
        this.roomsQty = roomsQty;
        this.street = street;
        this.typeOfBuilding = typeOfBuilding;
        this.yearsOfExploitation = yearsOfExploitation;
    }

    public House() {}

    public long getId() {
        return id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public int getSquare() {
        return square;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomsQty() {
        return roomsQty;
    }

    public String getStreet() {
        return street;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public int getYearsOfExploitation() {
        return yearsOfExploitation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoomsQty(int roomQty) {
        this.roomsQty = roomQty;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTypeOfBuilding(String typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }

    public void setYearsOfExploitation(int yearsOfExploitation) {
        this.yearsOfExploitation = yearsOfExploitation;
    }

    @Override
    public String toString() {
        return id + " " +
                flatNumber + " " +
                square + " " +
                floor + " " +
                roomsQty + " " +
                street + " " +
                typeOfBuilding + " " +
                yearsOfExploitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id &&
                flatNumber == house.flatNumber &&
                square == house.square &&
                floor == house.floor &&
                roomsQty == house.roomsQty &&
                yearsOfExploitation == house.yearsOfExploitation &&
                Objects.equals(street, house.street) &&
                Objects.equals(typeOfBuilding, house.typeOfBuilding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flatNumber, square, floor, roomsQty, street, typeOfBuilding, yearsOfExploitation);
    }

    public static House[] fileReader(long lines) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        House[] houses = new House[(int)lines];
        for (int i = 0; i < houses.length; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            houses[i] = new House(
                    Long.parseLong(arrayOfFileLine[0]),
                    Integer.parseInt(arrayOfFileLine[1]),
                    Integer.parseInt(arrayOfFileLine[2]),
                    Integer.parseInt(arrayOfFileLine[3]),
                    Integer.parseInt(arrayOfFileLine[4]),
                    arrayOfFileLine[5],
                    arrayOfFileLine[6],
                    Integer.parseInt(arrayOfFileLine[7]));
        }
        return houses;
    }

    public static List<String> flatsWithSameRoomsQty(House[] houses, int roomsQty) {
        if (houses == null || houses.length == 0 || roomsQty < 1) {
            return List.of();
        }
        List<String> listOfHouses = new ArrayList<>();
        for (House house: houses) {
            if (house.roomsQty == roomsQty) {
                listOfHouses.add(house.toString());
            }
        }
        return listOfHouses;
    }
    public static List<String> flatsWithSameRoomsQtyAndIntervalFloor(House[] houses, int roomsQty, int floorStart, int floorFinal) {
        // return list with flats which have the same quantity of rooms and locates on floor between input interval
        if (houses == null || houses.length == 0 || floorStart < 0 || floorFinal < 0 || roomsQty < 1 || floorFinal < floorStart) {
            return List.of();
        }
        List<String> listOfHouses = new ArrayList<>();
        for (House house: houses) {
            if ((house.roomsQty == roomsQty) && (floorStart <= house.floor) && (house.floor <= floorFinal)) {
                listOfHouses.add(house.toString());
            }
        }
        return listOfHouses;
    }

    public static List<String> flatsWithOverInputSquare(House[] houses, int square) {
        // return list with flats which have square over then input square
        if (houses == null || houses.length == 0 || square < 0) {
            return List.of();
        }
        List<String> listOfHouses = new ArrayList<>();
        for (House house: houses) {
            if (house.square > square) {
                listOfHouses.add(house.toString());
            }
        }
        return listOfHouses;
    }
    public static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}