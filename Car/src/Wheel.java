import java.util.Objects;

public class Wheel {
    public int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "diameter = " + diameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    public void changeWheel() {
        System.out.println("The wheel was changed");
    }
}
