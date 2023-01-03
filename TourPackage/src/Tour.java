import java.util.*;

public abstract class Tour {
    public int price;
    public String typeOfTransport;
    public String place;
    public String typeOfFood;
    public int days;

    public Tour(int price, String typeOfTransport, String place, String typeOfFood, int days) {
        this.price = price;
        this.typeOfTransport = typeOfTransport;
        this.place = place;
        this.typeOfFood = typeOfFood;
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public String getPlace() {
        return place;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public int getDays() {
        return days;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return price == tour.price && days == tour.days && Objects.equals(typeOfTransport, tour.typeOfTransport) && Objects.equals(place, tour.place) && Objects.equals(typeOfFood, tour.typeOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, typeOfTransport, place, typeOfFood, days);
    }

    public static <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}