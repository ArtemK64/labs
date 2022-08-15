import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Circle[] circles = Circle.fileReader();
        Circle circle = new Circle();

        System.out.println("File content:");
        circle.printArray(circles);

        System.out.println("\nPerimeters:");
        circle.printList(circle.circlePerimeter(circles));

        System.out.println("\nAreas:");
        circle.printList(Circle.circleArea(circles));

        System.out.print("\nCircles on one straight line:");
        circle.circlesOnStraightLine(circles);

        circle.maxMinPerimeterArea(circles);
    }
}