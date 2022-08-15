import java.io.*;
import java.util.*;

public abstract class Appliances {
    public int power;
    public String color;
    public int price;
    public boolean isPlugged;

    public Appliances(int power, String color, int price, boolean isPlugged) {
        this.power = power;
        this.color = color;
        this.price = price;
        this.isPlugged = isPlugged;
    }

    public int getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPlugged() {
        return isPlugged;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPlugged(boolean plugged) {
        isPlugged = plugged;
    }

    @Override
    public String toString() {
        return "Appliances {" +
                "power = " + power +
                ", color = " + color +
                ", price = " + price +
                ", isPlugged = " + isPlugged +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliances that = (Appliances) o;
        return power == that.power && price == that.price && isPlugged == that.isPlugged && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, color, price, isPlugged);
    }

    public static void readFile(List<Computer> computers, List<Microwave> microwaves, List<TV> tvs) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine()) {
            case "Computer":
                while((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        computers.add(new Computer(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Integer.parseInt(arrayOfFileLine[2]),
                                Boolean.parseBoolean(arrayOfFileLine[3]),
                                Integer.parseInt(arrayOfFileLine[4]))
                        );
                    }
                }
            case "Microwave":
                while((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        microwaves.add(new Microwave(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Integer.parseInt(arrayOfFileLine[2]),
                                Boolean.parseBoolean(arrayOfFileLine[3]),
                                Double.parseDouble(arrayOfFileLine[4]))
                        );
                    }
                }
            case "TV":
                while((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        tvs.add(new TV(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Integer.parseInt(arrayOfFileLine[2]),
                                Boolean.parseBoolean(arrayOfFileLine[3]),
                                Double.parseDouble(arrayOfFileLine[4]))
                        );
                    }
                }
        }
    }

    public static void calcPower(List<Computer> computers, List<Microwave> microwaves, List<TV> tvs) {
        System.out.println("\nTotal amount of power of plugged devices: " + (
                        Computer.calcPower(computers) +
                        Microwave.calcPower(microwaves) +
                        TV.calcPower(tvs)));
    }

    public static void intervalOfPrices(List<Computer> computers, List<Microwave> microwaves, List<TV> tvs, int startPrice, int endPrice) {
        Appliances.print(Computer.intervalOfPrices(computers, startPrice, endPrice));
        Appliances.print(Microwave.intervalOfPrices(microwaves, startPrice, endPrice));
        Appliances.print(TV.intervalOfPrices(tvs, startPrice, endPrice));
    }

    public static <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}