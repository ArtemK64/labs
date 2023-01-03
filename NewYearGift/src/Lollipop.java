import java.util.*;

public class Lollipop extends Candy {
    public String flavor;

    public Lollipop(int percentOfSugar, int qty, String brand, int weight, String flavor) {
        this.percentOfSugar = percentOfSugar;
        this.qty = qty;
        this.brand = brand;
        this.weight = weight;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Lollipop {" +
                "percentOfSugar = " + percentOfSugar +
                ", qty = " + qty +
                ", brand = " + brand +
                ", weight = " + weight +
                ", flavor = " + flavor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lollipop lollipop = (Lollipop) o;
        return Objects.equals(flavor, lollipop.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor);
    }

    public static void defineWeight(List<Lollipop> lollipops) {
        int sum = 0;
        for (Lollipop l: lollipops) {
            sum += l.weight;
        }
        System.out.println("Weight of lollipops: " + sum);
    }

    public static void definePercentOfSugar(List<Lollipop> lollipops, int start, int end) {
        List<Lollipop> resultLollipops = new ArrayList<>();
        for (Lollipop l: lollipops) {
            if (start < l.getPercentOfSugar() && l.getPercentOfSugar() < end) {
                resultLollipops.add(l);
            }
        }
        Candy.print(resultLollipops);
    }

    public static void sort(List<Lollipop> lollipops) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by PERCENT OF SUGAR / QTY / BRAND / WEIGHT / FLAVOR");
        System.out.print("Input: ");
        String keyWord = scanner.nextLine().toLowerCase().replaceAll(" +", " ").trim();

        switch (keyWord) {
            case "percent of sugar" -> {
                Comparator<Lollipop> byPercentOfSugar = Comparator.comparing(Lollipop::getPercentOfSugar);
                lollipops.sort(byPercentOfSugar);
                Candy.print(lollipops);
            }
            case "qty" -> {
                Comparator<Lollipop> byQty = Comparator.comparing(Lollipop::getQty);
                lollipops.sort(byQty);
                Candy.print(lollipops);
            }
            case "brand" -> {
                Comparator<Lollipop> byBrand = Comparator.comparing(Lollipop::getBrand);
                lollipops.sort(byBrand);
                Candy.print(lollipops);
            }
            case "weight" -> {
                Comparator<Lollipop> byWeight = Comparator.comparing(Lollipop::getWeight);
                lollipops.sort(byWeight);
                Candy.print(lollipops);
            }
            case "flavor" -> {
                Comparator<Lollipop> byFlavor = Comparator.comparing(Lollipop::getFlavor);
                lollipops.sort(byFlavor);
                Candy.print(lollipops);
            }
            default -> System.out.println("You wrote a wrong input");
        }
    }
}