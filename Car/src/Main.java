public class Main {
    public static void main(String[] args) {
        Car car = new Car(205, 250, "BMW");
        car.move();
        car.refuel();
        car.changeWheel();
        car.showBrand();
        System.out.println(car);
    }
}