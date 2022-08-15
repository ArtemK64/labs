import java.util.Objects;

public class Ocean extends Island {
    public int qtyOfIslands;

    public Ocean(String name, int qtyOfIslands) {
        super(name);
        this.qtyOfIslands = qtyOfIslands;
    }

    public int getQtyOfIslands() {
        return qtyOfIslands;
    }

    public void setQtyOfIslands(int qtyOfIslands) {
        this.qtyOfIslands = qtyOfIslands;
    }

    @Override
    public String toString() {
        return "Ocean{" +
                "qtyOfIslands = " + qtyOfIslands + ", " +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ocean ocean = (Ocean) o;
        return qtyOfIslands == ocean.qtyOfIslands;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qtyOfIslands);
    }
}
