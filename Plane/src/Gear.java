import java.util.Objects;

public class Gear {
    public int qtyOfWheels;

    public Gear(int qtyOfWheels) {
        this.qtyOfWheels = qtyOfWheels;
    }

    public int getQtyOfWheels() {
        return qtyOfWheels;
    }

    public void setQtyOfWheels(int qtyOfWheels) {
        this.qtyOfWheels = qtyOfWheels;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "qtyOfWheels = " + qtyOfWheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return qtyOfWheels == gear.qtyOfWheels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtyOfWheels);
    }
}
