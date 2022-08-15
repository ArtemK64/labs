import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Triangle {
    public int a;
    public int b;
    public int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Triangle() {}

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a == triangle.a && b == triangle.b && c == triangle.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
    public static Triangle[] fileReader() throws IOException {
        long countLines;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            countLines = stream.count();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        Triangle[] triangles = new Triangle[(int)countLines];
        for (int i = 0; i < countLines; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            triangles[i] = new Triangle(
                    Integer.parseInt(arrayOfFileLine[0]),
                    Integer.parseInt(arrayOfFileLine[1]),
                    Integer.parseInt(arrayOfFileLine[2]));
        }
        return triangles;
    }
    public static List<Object> trianglePerimeter(Triangle[] triangles) {
        List<Object> listOfPerimeters = new ArrayList<>();
        for (Triangle triangle: triangles) {
            listOfPerimeters.add(calcPerimeter(triangle));
        }
        return listOfPerimeters;
    }
    public static int calcPerimeter(Triangle triangle) {
        return triangle.a + triangle.b + triangle.c;
    }
    public static List<Object> triangleArea(Triangle[] triangles) {
        List<Object> listOfAreas = new ArrayList<>();
        for (Triangle triangle: triangles) {
            listOfAreas.add(calcArea(triangle));
        }
        return listOfAreas;
    }
    public static double calcArea(Triangle triangle) {
        double semiPerimeter = (triangle.a + triangle.b + triangle.c) / 2.0;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.a) * (semiPerimeter - triangle.b) * (semiPerimeter - triangle.c));
    }
    public static void typeOfTriangle(Triangle[] triangles) {
        List<Triangle> listOfEquilateralTriangles = new ArrayList<>();
        List<Triangle> listOfRightTriangles = new ArrayList<>();
        List<Triangle> listOfIsoscelesTriangles = new ArrayList<>();
        List<Triangle> listOfArbitraryTriangles = new ArrayList<>();

        for (Triangle triangle: triangles) {
            switch (checkTriangle(triangle)) {
                case "Equilateral Triangle" -> listOfEquilateralTriangles.add(triangle);
                case "Right Triangle" -> listOfRightTriangles.add(triangle);
                case "Isosceles Triangle" -> listOfIsoscelesTriangles.add(triangle);
                case "Arbitrary Triangle" -> listOfArbitraryTriangles.add(triangle);
            }
        }
        System.out.println("\nEquilateral Triangles:");
        equilateralTrianglesAnalysis(listOfEquilateralTriangles);

        System.out.println("\nRight Triangle:");
        equilateralTrianglesAnalysis(listOfRightTriangles);

        System.out.println("\nIsosceles Triangles:");
        equilateralTrianglesAnalysis(listOfIsoscelesTriangles);

        System.out.println("\nArbitrary Triangles:");
        equilateralTrianglesAnalysis(listOfArbitraryTriangles);
    }
    public static void equilateralTrianglesAnalysis(List<Triangle> triangles) {
        if (triangles.isEmpty()) {
            System.out.println("There are no triangles");
        }
        else {
            System.out.println("There are " + triangles.size() + " triangles");
            Triangle maxPerimeterObject = new Triangle();
            Triangle maxAreaObject = new Triangle();
            int maxPerimeter = Integer.MIN_VALUE;
            double maxArea = Double.MIN_VALUE;

            Triangle minPerimeterObject = new Triangle();
            Triangle minAreaObject = new Triangle();
            int minPerimeter = Integer.MAX_VALUE;
            double minArea = Double.MAX_VALUE;

            for (Triangle triangle: triangles) {
                if (maxPerimeter < calcPerimeter(triangle)) {
                    maxPerimeter = calcPerimeter(triangle);
                    maxPerimeterObject = triangle;
                }
                if (maxArea < calcArea(triangle)) {
                    maxArea = calcArea(triangle);
                    maxAreaObject = triangle;
                }
                if (minPerimeter > calcPerimeter(triangle)) {
                    minPerimeter = calcPerimeter(triangle);
                    minPerimeterObject = triangle;
                }
                if (minArea > calcArea(triangle)) {
                    minArea = calcArea(triangle);
                    minAreaObject = triangle;
                }
            }
            System.out.println("Max Perimeter Object is " + "(" + maxPerimeterObject + ")" + " = " + maxPerimeter);
            System.out.println("Max Area Object is " + "(" + maxAreaObject + ")" + " = " + maxArea);
            System.out.println("Min Perimeter Object is " + "(" + minPerimeterObject + ")" + " = " + minPerimeter);
            System.out.println("Min Area Object is " + "(" + minAreaObject + ")" + " = " + minArea);
        }
    }
    public static String checkTriangle(Triangle triangle) {
        if (triangle.a >= triangle.b + triangle.c ||
            triangle.b >= triangle.a + triangle.c ||
            triangle.c >= triangle.a + triangle.b) {
            return "Not a triangle";
        }
        else if (triangle.a == triangle.b && triangle.b == triangle.c) {
            return "Equilateral Triangle";
        }
        else if (triangle.a * triangle.a + triangle.b * triangle.b == triangle.c * triangle.c ||
                triangle.b * triangle.b + triangle.c * triangle.c == triangle.a * triangle.a ||
                triangle.c * triangle.c + triangle.a * triangle.a == triangle.b * triangle.b) {
            return "Right Triangle";
        }
        else if (triangle.a == triangle.b || triangle.c == triangle.a || triangle.c == triangle.b) {
            return "Isosceles Triangle";
        }
        else {
            return "Arbitrary Triangle";
        }
    }
    public static void printArray(Triangle[] triangles) {
        for (Triangle triangle: triangles) {
            System.out.println(triangle.toString());
        }
    }
    public static void printList(List<Object> list) {
        for (Object obj: list) {
            System.out.println(obj);
        }
    }
}