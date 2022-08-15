import java.util.Objects;

public class Car extends Engine {

    public String brand;

    public Car(int diameter, int power, String brand) {
        super(diameter, power);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power = " + power + ", " +
                "diameter = " + diameter + ", " +
                "brand = " + brand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }

    public void move() {
        System.out.println("The car is moving");
    }

    public void showBrand() {
        System.out.println("Brand: " + brand);
    }
}