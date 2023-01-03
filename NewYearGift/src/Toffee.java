import java.util.*;

public class Toffee extends Candy {
    public String viscosity;

    public Toffee(int percentOfSugar, int qty, String brand, int weight, String viscosity) {
        this.percentOfSugar = percentOfSugar;
        this.qty = qty;
        this.brand = brand;
        this.weight = weight;
        this.viscosity = viscosity;
    }

    public String getViscosity() {
        return viscosity;
    }

    public void setViscosity(String viscosity) {
        this.viscosity = viscosity;
    }

    @Override
    public String toString() {
        return "Toffee {" +
                "percentOfSugar = " + percentOfSugar +
                ", qty = " + qty +
                ", brand = " + brand +
                ", weight = " + weight +
                ", viscosity = " + viscosity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toffee toffee = (Toffee) o;
        return Objects.equals(viscosity, toffee.viscosity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viscosity);
    }

    public static void defineWeight(List<Toffee> toffees) {
        int sum = 0;
        for (Toffee t: toffees) {
            sum += t.weight;
        }
        System.out.println("Weight of toffees: " + sum);
    }

    public static void definePercentOfSugar(List<Toffee> toffees, int start, int end) {
        List<Toffee> resultToffees = new ArrayList<>();
        for (Toffee t: toffees) {
            if (start < t.getPercentOfSugar() && t.getPercentOfSugar() < end) {
                resultToffees.add(t);
            }
        }
        Candy.print(resultToffees);
    }

    public static void sort(List<Toffee> toffees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by PERCENT OF SUGAR / QTY / BRAND / WEIGHT / VISCOSITY");
        System.out.print("Input: ");
        String keyWord = scanner.nextLine().toLowerCase().replaceAll(" +", " ").trim();

        switch (keyWord) {
            case "percent of sugar" -> {
                Comparator<Toffee> byPercentOfSugar = Comparator.comparing(Toffee::getPercentOfSugar);
                toffees.sort(byPercentOfSugar);
                Candy.print(toffees);
            }
            case "qty" -> {
                Comparator<Toffee> byQty = Comparator.comparing(Toffee::getQty);
                toffees.sort(byQty);
                Candy.print(toffees);
            }
            case "brand" -> {
                Comparator<Toffee> byBrand = Comparator.comparing(Toffee::getBrand);
                toffees.sort(byBrand);
                Candy.print(toffees);
            }
            case "weight" -> {
                Comparator<Toffee> byWeight = Comparator.comparing(Toffee::getWeight);
                toffees.sort(byWeight);
                Candy.print(toffees);
            }
            case "viscosity" -> {
                Comparator<Toffee> byViscosity = Comparator.comparing(Toffee::getViscosity);
                toffees.sort(byViscosity);
                Candy.print(toffees);
            }
            default -> System.out.println("You wrote a wrong input");
        }
    }
}