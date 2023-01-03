import java.util.*;

public class Boots extends Equipment implements Comparable<Boots> {
    public String season;

    public Boots(int price, String color, double weight, String season) {
        super(price, color, weight);
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Boots {" +
                "price = " + price +
                ", color = " + color +
                ", weight = " + weight +
                ", season = " + season +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boots boots = (Boots) o;
        return Objects.equals(season, boots.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), season);
    }

    @Override
    public int compareTo(Boots o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public static List<Boots> sortByWeight(List<Boots> bootsList) {
        Collections.sort(bootsList);
        return bootsList;
    }
}