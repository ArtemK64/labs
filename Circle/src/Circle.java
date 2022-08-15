import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Circle {
    public int x;
    public int y;
    public int radius;
    public Circle (int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public Circle(){}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", Radius = " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return x == circle.x && y == circle.y && radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius);
    }

    public static Circle[] fileReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        long lineCount;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            lineCount = stream.count();
        }
        Circle[] circles = new Circle[(int)lineCount];
        for (int i = 0; i < lineCount; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            circles[i] = new Circle(Integer.parseInt(arrayOfFileLine[0]), Integer.parseInt(arrayOfFileLine[1]), Integer.parseInt(arrayOfFileLine[2]));
        }
        return circles;
    }

    public List<Object> circlePerimeter(Circle[] circles) {
        List<Object> listOfPerimeters = new ArrayList<>();
        for (Circle circle: circles) {
            listOfPerimeters.add(calcPerimeter(circle));
        }
        return listOfPerimeters;
    }

    public double calcPerimeter(Circle circle) {
        return Math.round(Math.PI * 2 * circle.radius * 10) / 10.;
    }

    public static List<Object> circleArea(Circle[] circles) {
        List<Object> listOfAreas = new ArrayList<>();
        for (Circle circle: circles) {
            listOfAreas.add(calcAreas(circle));
        }
        return listOfAreas;
    }

    public static double calcAreas(Circle circle) {
        return Math.round(Math.PI * circle.radius * circle.radius * 10) / 10.;
    }

    public int[] maxCoordinates(Circle[] circles) {
        int maxX = circles[0].x;
        int maxY = circles[0].y;

        for (Circle circle: circles) {
            if (circle.x > maxX) {
                maxX = circle.x;
            }
            if (circle.y > maxY) {
                maxY = circle.y;
            }
        }
        return new int[]{maxX, maxY};
    }

    public void circlesOnStraightLine(Circle[] circles) {
        int maxX = maxCoordinates(circles)[0];
        int maxY = maxCoordinates(circles)[1];
        for (int i = 0; i < maxX; i++) {
            System.out.print("\nx = " + i + ". Circles: ");
            for (Circle circle: circles) {
                if (circle.x == i) {
                    System.out.print("(" + circle + ") ");
                }
            }
        }
        for (int i = 0; i < maxY; i++) {
            System.out.print("\ny = " + i + ". Circles: ");
            for (Circle circle: circles) {
                if (circle.y == i) {
                    System.out.print("(" + circle + ") ");
                }
            }
        }
    }

    public void maxMinPerimeterArea(Circle[] circles) {
        double minPerimeter = Integer.MAX_VALUE;
        double minArea = Double.MAX_VALUE;

        double maxPerimeter = Integer.MIN_VALUE;
        double maxArea = Double.MIN_VALUE;

        Circle minPerimeterObject = new Circle();
        Circle minAreaObject = new Circle();
        Circle maxPerimeterObject = new Circle();
        Circle maxAreaObject = new Circle();

        for (Circle circle: circles) {
            if (calcPerimeter(circle) < minPerimeter) {
                minPerimeter = calcPerimeter(circle);
                minPerimeterObject = circle;
            }
            if (calcAreas(circle) < minArea) {
                minArea = calcAreas(circle);
                minAreaObject = circle;
            }
            if (calcPerimeter(circle) > maxPerimeter) {
                maxPerimeter = calcPerimeter(circle);
                maxPerimeterObject = circle;
            }
            if (calcAreas(circle) > maxArea) {
                maxArea = calcAreas(circle);
                maxAreaObject = circle;
            }
        }

        System.out.println("\n\nMin perimeter object is (" + minPerimeterObject + ") = " + minPerimeter);
        System.out.println("Max perimeter object is (" + maxPerimeterObject + ") = " + maxPerimeter);
        System.out.println("Min area object is (" + minAreaObject + ") = " + minArea);
        System.out.println("Max area object is (" + maxAreaObject + ") = " + maxArea);
    }

    public void printArray(Circle[] circles) {
        for (Circle circle: circles) {
            System.out.println(circle.toString());
        }
    }

    public void printList(List<Object> list) {
        for (Object obj: list) {
            System.out.println(obj);
        }
    }
}