import java.util.Objects;

public class Island {
    public String name;

    public Island(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Island{" +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Island island = (Island) o;
        return Objects.equals(name, island.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
