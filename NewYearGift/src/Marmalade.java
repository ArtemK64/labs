import java.util.*;

public class Marmalade extends Candy {
    public String thickener;

    public Marmalade(int percentOfSugar, int qty, String brand, int weight, String thickener) {
        this.percentOfSugar = percentOfSugar;
        this.qty = qty;
        this.brand = brand;
        this.weight = weight;
        this.thickener = thickener;
    }

    public String getThickener() {
        return thickener;
    }

    public void setThickener(String thickener) {
        this.thickener = thickener;
    }

    @Override
    public String toString() {
        return "Marmalade {" +
                "percentOfSugar = " + percentOfSugar +
                ", qty = " + qty +
                ", brand = " + brand +
                ", weight = " + weight +
                ", thickener = " + thickener +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marmalade marmalade = (Marmalade) o;
        return Objects.equals(thickener, marmalade.thickener);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thickener);
    }

    public static void defineWeight(List<Marmalade> marmalade) {
        int sum = 0;
        for (Marmalade m: marmalade) {
            sum += m.weight;
        }
        System.out.println("Weight of marmalade: " + sum);
    }

    public static void definePercentOfSugar(List<Marmalade> marmalade, int start, int end) {
        List<Marmalade> resultMarmalade = new ArrayList<>();
        for (Marmalade m: marmalade) {
            if (start < m.getPercentOfSugar() && m.getPercentOfSugar() < end) {
                resultMarmalade.add(m);
            }
        }
        Candy.print(resultMarmalade);
    }

    public static void sort(List<Marmalade> marmalade) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by PERCENT OF SUGAR / QTY / BRAND / WEIGHT / THICKENER");
        System.out.print("Input: ");
        String keyWord = scanner.nextLine().toLowerCase().replaceAll(" +", " ").trim();

        switch (keyWord) {
            case "percent of sugar" -> {
                Comparator<Marmalade> byPercentOfSugar = Comparator.comparing(Marmalade::getPercentOfSugar);
                marmalade.sort(byPercentOfSugar);
                Candy.print(marmalade);
            }
            case "qty" -> {
                Comparator<Marmalade> byQty = Comparator.comparing(Marmalade::getQty);
                marmalade.sort(byQty);
                Candy.print(marmalade);
            }
            case "brand" -> {
                Comparator<Marmalade> byBrand = Comparator.comparing(Marmalade::getBrand);
                marmalade.sort(byBrand);
                Candy.print(marmalade);
            }
            case "weight" -> {
                Comparator<Marmalade> byWeight = Comparator.comparing(Marmalade::getWeight);
                marmalade.sort(byWeight);
                Candy.print(marmalade);
            }
            case "thickener" -> {
                Comparator<Marmalade> byThickener = Comparator.comparing(Marmalade::getThickener);
                marmalade.sort(byThickener);
                Candy.print(marmalade);
            }
            default -> System.out.println("You wrote a wrong input");
        }
    }
}