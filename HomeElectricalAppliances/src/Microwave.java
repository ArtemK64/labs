import java.util.*;

public class Microwave extends Appliances implements Comparable<Microwave> {
    public double volume;

    public Microwave(int power, String color, int price, boolean isPlugged, double volume) {
        super(power, color, price, isPlugged);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Microwave {" +
                "power = " + power +
                ", color = " + color +
                ", price = " + price +
                ", isPlugged = " + isPlugged +
                ", volume = " + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Microwave microwave = (Microwave) o;
        return Double.compare(microwave.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }

    @Override
    public int compareTo(Microwave o) {
        return this.power - o.getPower();
    }

    public static int calcPower(List<Microwave> microwaves) {
        int sum = 0;
        for (Microwave microwave: microwaves) {
            if (microwave.isPlugged) {
                sum += microwave.getPower();
            }
        }
        return sum;
    }

    public static List<Microwave> sortByPower(List<Microwave> microwaves) {
        Collections.sort(microwaves);
        return microwaves;
    }

    public static List<Microwave> intervalOfPrices(List<Microwave> microwaves, int startPrice, int endPrice) {
        List<Microwave> resultMicrowaves = new ArrayList<>();
        for (Microwave microwave: microwaves) {
            if (startPrice < microwave.getPrice() && microwave.getPrice() < endPrice) {
                resultMicrowaves.add(microwave);
            }
        }
        return resultMicrowaves;
    }

    public static List<Microwave> intervalOfVolume(List<Microwave> microwaves, int startVolume, int endVolume) {
        List<Microwave> resultMicrowaves = new ArrayList<>();
        for (Microwave microwave: microwaves) {
            if (startVolume < microwave.getVolume() && microwave.getVolume() < endVolume) {
                resultMicrowaves.add(microwave);
            }
        }
        return resultMicrowaves;
    }
}