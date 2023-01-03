import java.util.*;

public class Jumpsuit extends Equipment implements Comparable<Jumpsuit> {
    public String cloth;

    public Jumpsuit(int price, String color, double weight, String cloth) {
        super(price, color, weight);
        this.cloth = cloth;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    @Override
    public String toString() {
        return "Jumpsuit {" +
                "price = " + price +
                ", color = " + color +
                ", weight = " + weight +
                ", cloth = " + cloth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jumpsuit jumpsuit = (Jumpsuit) o;
        return Objects.equals(cloth, jumpsuit.cloth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cloth);
    }

    @Override
    public int compareTo(Jumpsuit o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public static List<Jumpsuit> sortByWeight(List<Jumpsuit> jumpsuitList) {
        Collections.sort(jumpsuitList);
        return jumpsuitList;
    }
}