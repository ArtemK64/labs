import java.util.*;

public class TV extends Appliances implements Comparable<TV> {
    public double diagonal;

    public TV(int power, String color, int price, boolean isPlugged, double diagonal) {
        super(power, color, price, isPlugged);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "TV {" +
                "power = " + power +
                ", color = " + color +
                ", price = " + price +
                ", isPlugged = " + isPlugged +
                ", diagonal = " + diagonal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return Double.compare(tv.diagonal, diagonal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal);
    }

    @Override
    public int compareTo(TV o) {
        return this.power - o.getPower();
    }

    public static int calcPower(List<TV> tvs) {
        int sum = 0;
        for (TV tv: tvs) {
            if (tv.isPlugged) {
                sum += tv.getPower();
            }
        }
        return sum;
    }

    public static List<TV> sortByPower(List<TV> tvs) {
        Collections.sort(tvs);
        return tvs;
    }

    public static List<TV> intervalOfPrices(List<TV> tvs, int startPrice, int endPrice) {
        List<TV> resultTvs = new ArrayList<>();
        for (TV tv: tvs) {
            if (startPrice < tv.getPrice() && tv.getPrice() < endPrice) {
                resultTvs.add(tv);
            }
        }
        return resultTvs;
    }

    public static List<TV> intervalOfDiagonals(List<TV> tvs, double startDiagonal, double endDiagonal) {
        List<TV> resultTV = new ArrayList<>();
        for (TV tv: tvs) {
            if (startDiagonal < tv.getDiagonal() && tv.getDiagonal() < endDiagonal) {
                resultTV.add(tv);
            }
        }
        return resultTV;
    }
}