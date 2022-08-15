public class Main {
    public static void main(String[] args) {
        Planet planet = new Planet("Earth", 10000, "Temperate", 6);
        planet.showName();
        planet.showQtyOfMainlands();

        Mainland mainland = new Mainland("Eurasia", 50, "Temperate");
        mainland.showName();
    }
}