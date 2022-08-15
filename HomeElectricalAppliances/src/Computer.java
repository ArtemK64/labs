import java.util.*;

public class Computer extends Appliances implements Comparable<Computer> {
    public int amountOfRAM;

    public Computer(int power, String color, int price, boolean isPlugged, int amountOfRAM) {
        super(power, color, price, isPlugged);
        this.amountOfRAM = amountOfRAM;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public void setAmountOfRAM(int amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    @Override
    public String toString() {
        return "Computer {" +
                "power = " + power +
                ", color = " + color +
                ", price = " + price +
                ", isPlugged = " + isPlugged +
                ", amountOfRAM = " + amountOfRAM +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return amountOfRAM == computer.amountOfRAM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfRAM);
    }

    @Override
    public int compareTo(Computer o) {
        return this.power - o.getPower();
    }

    public static int calcPower(List<Computer> computers) {
        int sum = 0;
        for (Computer computer: computers) {
            if (computer.isPlugged) {
                sum += computer.getPower();
            }
        }
        return sum;
    }

    public static List<Computer> sortByPower(List<Computer> computers) {
        Collections.sort(computers);
        return computers;
    }

    public static List<Computer> intervalOfPrices(List<Computer> computers, int startPrice, int endPrice) {
        List<Computer> resultComputers = new ArrayList<>();
        for (Computer computer: computers) {
            if (startPrice < computer.getPrice() && computer.getPrice() < endPrice) {
                resultComputers.add(computer);
            }
        }
        return resultComputers;
    }

    public static List<Computer> RAMInterval(List<Computer> computers, int startAmountOfRAM, int endAmountOfRAM) {
        List<Computer> resultComputers = new ArrayList<>();
        for (Computer computer: computers) {
            if (startAmountOfRAM < computer.getAmountOfRAM() && computer.getAmountOfRAM() < endAmountOfRAM) {
                resultComputers.add(computer);
            }
        }
        return resultComputers;
    }
}