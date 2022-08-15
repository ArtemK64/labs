import java.util.Objects;

public class Wing extends Engine {
    public int size;

    public Wing(int qtyOfWheels, int power, int size) {
        super(qtyOfWheels, power);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Wing{" +
                "size = " + size + ", " +
                "power = " + power + ", " +
                "qtyOfWheels = " + qtyOfWheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wing wing = (Wing) o;
        return size == wing.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
