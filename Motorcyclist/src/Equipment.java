import java.util.Objects;

public abstract class Equipment {
    public int price;
    public String color;
    public double weight;

    public Equipment(int price, String color, double weight) {
        this.price = price;
        this.color = color;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Equipment {" +
                "price = " + price +
                ", color = " + color +
                ", weight = " + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return price == equipment.price && Double.compare(equipment.weight, weight) == 0 && Objects.equals(color, equipment.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, color, weight);
    }
}