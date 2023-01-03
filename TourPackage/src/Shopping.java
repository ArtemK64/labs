import java.util.*;

public class Shopping extends Tour {
    public int qtyOfShops;

    public Shopping(int price, String typeOfTransport, String place, String typeOfFood, int days, int qtyOfShops) {
        super(price, typeOfTransport, place, typeOfFood, days);
        this.qtyOfShops = qtyOfShops;
    }

    public int getQtyOfShops() {
        return qtyOfShops;
    }

    public void setQtyOfShops(int qtyOfShops) {
        this.qtyOfShops = qtyOfShops;
    }

    @Override
    public String toString() {
        return "Shopping {" +
                "price = " + price +
                ", typeOfTransport = " + typeOfTransport +
                ", place = " + place +
                ", typeOfFood = " + typeOfFood +
                ", days = " + days +
                ", qtyOfShops = " + qtyOfShops +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shopping shopping = (Shopping) o;
        return qtyOfShops == shopping.qtyOfShops;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qtyOfShops);
    }

    public static List<Shopping> sortByPrice(List<Shopping> shoppingList) {
        Comparator<Shopping> byPrice = Comparator.comparing(Shopping::getPrice);
        shoppingList.sort(byPrice);
        return shoppingList;
    }
}