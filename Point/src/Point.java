import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Point {
    public Fraction x;
    public Fraction y;
    public Fraction z;

    public Point(Fraction x, Fraction y, Fraction z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {}

    public Fraction getX() {
        return x;
    }

    public Fraction getY() {
        return y;
    }

    public Fraction getZ() {
        return z;
    }

    public void setX(Fraction x) {
        this.x = x;
    }

    public void setY(Fraction y) {
        this.y = y;
    }

    public void setZ(Fraction z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y) && Objects.equals(z, point.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public static Point[] fileReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }
        Point[] points = new Point[(int)countLines];
        for (int i = 0; i < countLines; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().replaceAll("/", " ").split(" ");

            points[i] = new Point(
                    new Fraction(Integer.parseInt(arrayOfFileLine[0]), Integer.parseInt(arrayOfFileLine[1])),
                    new Fraction(Integer.parseInt(arrayOfFileLine[2]), Integer.parseInt(arrayOfFileLine[3])),
                    new Fraction(Integer.parseInt(arrayOfFileLine[4]), Integer.parseInt(arrayOfFileLine[5])));
        }
        return points;
    }

    public static List<Object> distanceBetweenPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return List.of();
        }
        List<Object> listOfDistance = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                listOfDistance.add("Distance between " + points[i] + " and " + points[j] + " = " + calcDistance(points[i], points[j]));
            }
        }
        return listOfDistance;
    }

    public static List<Object> distanceBetweenOriginOfCoordinates(Point[] points) {
        if (points == null || points.length == 0) {
            return List.of();
        }
        List<Object> listOfDistance = new ArrayList<>();
        for (Point point: points) {
            listOfDistance.add("Distance between " + point + " and origin of coordinates = " +
                    calcDistance(point));
        }
        return listOfDistance;
    }

    public static double calcDistance(Point point) {
        if (point == null) {
            return 0;
        }
        double distance = Math.sqrt(
                Math.pow((double)point.x.numerator / point.x.denominator, 2) +
                Math.pow((double)point.y.numerator / point.y.denominator, 2) +
                Math.pow((double)point.z.numerator / point.z.denominator, 2));
        return Math.round(distance * 100) / 100.;
    }

    public static double calcDistance(Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            return 0;
        }
        double distance = Math.sqrt(
                Math.pow(((double)p2.x.numerator / p2.x.denominator) - ((double)p1.x.numerator / p1.x.denominator), 2) +
                Math.pow(((double)p2.y.numerator / p2.y.denominator) - ((double)p1.y.numerator / p1.y.denominator), 2) +
                Math.pow(((double)p2.z.numerator / p2.z.denominator) - ((double)p1.z.numerator / p1.z.denominator), 2));
        return Math.round(distance * 100) / 100.;
    }

    public static boolean threePointsLocateOnStraightLine(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null) {
            return false;
        }
        double x = ((double)p3.x.numerator / p3.x.denominator - (double)p1.x.numerator / p1.x.denominator) /
                ((double)p2.x.numerator / p2.x.denominator - (double)p1.x.numerator / p1.x.denominator);
        double y = ((double)p3.y.numerator / p3.y.denominator - (double)p1.y.numerator / p1.y.denominator) /
                ((double)p2.y.numerator / p2.y.denominator - (double)p1.y.numerator / p1.y.denominator);
        double z = ((double)p3.z.numerator / p3.z.denominator - (double)p1.z.numerator / p1.z.denominator) /
                ((double)p2.z.numerator / p2.z.denominator - (double)p1.z.numerator / p1.z.denominator);
        return x == y && y == z;
    }

    public static void printList(List<Object> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        for (Object obj: list) {
            System.out.println(obj);
        }
    }

    public static void printArray(Point[] points) {
        for (Point point: points) {
            System.out.println(point.toString());
        }
    }
}