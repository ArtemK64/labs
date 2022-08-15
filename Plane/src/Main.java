public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane(6, 110000, 20, "Flower");
        plane.fly();
        plane.setRoute();
        plane.showRoute();
        System.out.println(plane);
    }
}