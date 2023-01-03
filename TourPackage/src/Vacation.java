import java.util.*;

public class Vacation extends Tour {
    public String typeOfRecreation;

    public Vacation(int price, String typeOfTransport, String place, String typeOfFood, int days, String typeOfRecreation) {
        super(price, typeOfTransport, place, typeOfFood, days);
        this.typeOfRecreation = typeOfRecreation;
    }

    public String getTypeOfRecreation() {
        return typeOfRecreation;
    }

    public void setTypeOfRecreation(String typeOfRecreation) {
        this.typeOfRecreation = typeOfRecreation;
    }

    @Override
    public String toString() {
        return "Vacation {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                ", typeOfRecreation = " + typeOfRecreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vacation vacation = (Vacation) o;
        return Objects.equals(typeOfRecreation, vacation.typeOfRecreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfRecreation);
    }

    public static List<Vacation> sortByPrice(List<Vacation> vacationList) {
        Comparator<Vacation> byPrice = Comparator.comparing(Vacation::getPrice);
        vacationList.sort(byPrice);
        return vacationList;
    }
}