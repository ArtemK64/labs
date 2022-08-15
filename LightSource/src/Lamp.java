import java.util.Objects;

public class Lamp {
    public String typeOfLightBulb;
    public int price;

    public Lamp(String typeOfLightBulb, int price) {
        this.typeOfLightBulb = typeOfLightBulb;
        this.price = price;
    }

    public Lamp() {}

    public String getTypeOfLightBulb() {
        return typeOfLightBulb;
    }

    public int getPrice() {
        return price;
    }

    public void setTypeOfLightBulb(String typeOfLightBulb) {
        this.typeOfLightBulb = typeOfLightBulb;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lamp {" +
                "typeOfLightBulb = " + typeOfLightBulb +
                ", price = " + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lamp lamp = (Lamp) o;
        return price == lamp.price && Objects.equals(typeOfLightBulb, lamp.typeOfLightBulb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfLightBulb, price);
    }
}