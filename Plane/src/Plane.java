import java.util.Objects;

public class Plane extends Wing {
    public String manufacturer;

    public Plane(int qtyOfWheels, int power, int size, String manufacturer) {
        super(qtyOfWheels, power, size);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "manufacturer = " + manufacturer + ", " +
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
        Plane plane = (Plane) o;
        return Objects.equals(manufacturer, plane.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    public void fly() {
        System.out.println("Plane is flying");
    }

    public void setRoute() {
        System.out.println("The route was set");
    }

    public void showRoute() {
        System.out.println("Route");
    }
}
