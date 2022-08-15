import java.util.Objects;

public class Engine extends Wheel {
    public int power;

    public Engine(int diameter, int power) {
        super(diameter);
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
                "diameter = " + diameter +
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

    public void refuel() {
        System.out.println("The car was refueled");
    }
}
