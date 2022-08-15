import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Point[] points = Point.fileReader();

        System.out.println("File content:");
        Point.printArray(points);

        System.out.println();
        Point.printList(Point.distanceBetweenPoints(points));

        System.out.println();
        Point.printList(Point.distanceBetweenOriginOfCoordinates(points));

        System.out.println("\nThree points locate on one straight line - " + Point.threePointsLocateOnStraightLine(points[0], points[1], points[2]));
    }
}