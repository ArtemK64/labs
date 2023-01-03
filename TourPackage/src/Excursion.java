import java.util.*;

public class Excursion extends Tour {
    public int numberOfAttractions;

    public Excursion(int price, String typeOfTransport, String place, String typeOfFood, int days, int numberOfAttractions) {
        super(price, typeOfTransport, place, typeOfFood, days);
        this.numberOfAttractions = numberOfAttractions;
    }

    public int getNumberOfAttractions() {
        return numberOfAttractions;
    }

    public void setNumberOfAttractions(int numberOfAttractions) {
        this.numberOfAttractions = numberOfAttractions;
    }

    @Override
    public String toString() {
        return "Excursion {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                ", numberOfAttractions = " + numberOfAttractions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Excursion excursion = (Excursion) o;
        return numberOfAttractions == excursion.numberOfAttractions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfAttractions);
    }

    public static List<Excursion> sortByPrice(List<Excursion> excursionList) {
        Comparator<Excursion> byPrice = Comparator.comparing(Excursion::getPrice);
        excursionList.sort(byPrice);
        return excursionList;
    }
}