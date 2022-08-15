import java.util.Objects;

public class Mainland extends Ocean {
    public String climate;

    public Mainland(String name, int qtyOfIslands, String climate) {
        super(name, qtyOfIslands);
        this.climate = climate;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    @Override
    public String toString() {
        return "Mainland{" +
                "climate = " + climate + ", " +
                "qtyOfIslands = " + qtyOfIslands + ", " +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mainland mainland = (Mainland) o;
        return Objects.equals(climate, mainland.climate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), climate);
    }

    public void showName() {
        System.out.println(name);
    }
}
