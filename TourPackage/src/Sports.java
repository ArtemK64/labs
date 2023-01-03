import java.util.*;

public class Sports extends Tour {
    public String[] sportsEvents;

    public Sports(int price, String typeOfTransport, String place, String typeOfFood, int days, String[] sportsEvents) {
        super(price, typeOfTransport, place, typeOfFood, days);
        this.sportsEvents = sportsEvents;
    }

    public String[] getSportsEvents() {
        return sportsEvents;
    }

    public void setSportsEvents(String[] sportsEvents) {
        this.sportsEvents = sportsEvents;
    }

    @Override
    public String toString() {
        return "Sports {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                ", sportsEvents = " + Arrays.toString(sportsEvents) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sports sports = (Sports) o;
        return Arrays.equals(sportsEvents, sports.sportsEvents);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(sportsEvents);
        return result;
    }

    public static List<Sports> sortByPrice(List<Sports> sportsList) {
        Comparator<Sports> byPrice = Comparator.comparing(Sports::getPrice);
        sportsList.sort(byPrice);
        return sportsList;
    }
}