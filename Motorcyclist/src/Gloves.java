import java.util.*;

public class Gloves extends Equipment implements Comparable<Gloves> {
    public String type;

    public Gloves(int price, String color, double weight, String type) {
        super(price, color, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Gloves {" +
                "price = " + price +
                ", color = " + color +
                ", weight = " + weight +
                ", type = " + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gloves gloves = (Gloves) o;
        return Objects.equals(type, gloves.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public int compareTo(Gloves o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public static List<Gloves> sortByWeight(List<Gloves> glovesList) {
        Collections.sort(glovesList);
        return glovesList;
    }
}