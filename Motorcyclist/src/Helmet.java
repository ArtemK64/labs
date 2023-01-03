import java.util.*;

public class Helmet extends Equipment implements Comparable<Helmet> {
    public boolean isComfortable;

    public Helmet(int price, String color, double weight, boolean isComfortable) {
        super(price, color, weight);
        this.isComfortable = isComfortable;
    }

    @Override
    public String toString() {
        return "Helmet {" +
                "price = " + price +
                ", color = " + color +
                ", weight = " + weight +
                ", isComfortable = " + isComfortable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Helmet helmet = (Helmet) o;
        return isComfortable == helmet.isComfortable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isComfortable);
    }

    @Override
    public int compareTo(Helmet o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public static List<Helmet> sortByWeight(List<Helmet> helmetList) {
        Collections.sort(helmetList);
        return helmetList;
    }
}