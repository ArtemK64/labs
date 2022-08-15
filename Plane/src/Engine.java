import java.util.Objects;

public class Engine extends Gear {
    public int power;

    public Engine(int qtyOfWheels, int power) {
        super(qtyOfWheels);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power = " + power + ", " +
                "qtyOfWheels = " + qtyOfWheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Engine engine = (Engine) o;
        return power == engine.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), power);
    }
}
