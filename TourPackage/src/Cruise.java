import java.util.*;

public class Cruise extends Tour {
    public String nameOfShip;

    public Cruise(int price, String typeOfTransport, String place, String typeOfFood, int days, String nameOfShip) {
        super(price, typeOfTransport, place, typeOfFood, days);
        this.nameOfShip = nameOfShip;
    }

    public String getNameOfShip() {
        return nameOfShip;
    }

    public void setNameOfShip(String nameOfShip) {
        this.nameOfShip = nameOfShip;
    }

    @Override
    public String toString() {
        return "Cruise {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                ", nameOfShip = " + nameOfShip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cruise cruise = (Cruise) o;
        return Objects.equals(nameOfShip, cruise.nameOfShip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfShip);
    }

    public static List<Cruise> sortByPrice(List<Cruise> cruiseList) {
        Comparator<Cruise> byPrice = Comparator.comparing(Cruise::getPrice);
        cruiseList.sort(byPrice);
        return cruiseList;
    }
}