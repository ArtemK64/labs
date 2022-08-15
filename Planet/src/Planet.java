import java.util.Objects;

public class Planet extends Mainland {
    public int qtyOfMainlands;

    public Planet(String name, int qtyOfIslands, String climate, int qtyOfMainlands) {
        super(name, qtyOfIslands, climate);
        this.qtyOfMainlands = qtyOfMainlands;
    }

    public int getQtyOfMainlands() {
        return qtyOfMainlands;
    }

    public void setQtyOfMainlands(int qtyOfMainlands) {
        this.qtyOfMainlands = qtyOfMainlands;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "qtyOfMainlands = " + qtyOfMainlands + ", " +
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
        Planet planet = (Planet) o;
        return qtyOfMainlands == planet.qtyOfMainlands;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qtyOfMainlands);
    }

    public void showQtyOfMainlands() {
        System.out.println(qtyOfMainlands);
    }
}
