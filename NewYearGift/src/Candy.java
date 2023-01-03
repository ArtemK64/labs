import java.io.*;
import java.util.*;

public abstract class Candy {
    public int percentOfSugar;
    public int qty;
    public String brand;
    public int weight;

    public int getPercentOfSugar() {
        return percentOfSugar;
    }

    public int getQty() {
        return qty;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setPercentOfSugar(int percentOfSugar) {
        this.percentOfSugar = percentOfSugar;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static void readFile(List<Marmalade> marmalade, List<Lollipop> lollipops, List<Toffee> toffees) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line = bufferedReader.readLine();
        switch (line) {
            case "Marmalade":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        marmalade.add(new Marmalade(
                                Integer.parseInt(arrayOfFileLine[0]),
                                Integer.parseInt(arrayOfFileLine[1]),
                                arrayOfFileLine[2],
                                Integer.parseInt(arrayOfFileLine[3]),
                                arrayOfFileLine[4]));
                    }
                }
            case "Lollipop":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        lollipops.add(new Lollipop(
                                Integer.parseInt(arrayOfFileLine[0]),
                                Integer.parseInt(arrayOfFileLine[1]),
                                arrayOfFileLine[2],
                                Integer.parseInt(arrayOfFileLine[3]),
                                arrayOfFileLine[4]));
                    }
                }
            case "Toffee":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        toffees.add(new Toffee(
                                Integer.parseInt(arrayOfFileLine[0]),
                                Integer.parseInt(arrayOfFileLine[1]),
                                arrayOfFileLine[2],
                                Integer.parseInt(arrayOfFileLine[3]),
                                arrayOfFileLine[4]));
                    }
                }
        }
    }
    public static <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}