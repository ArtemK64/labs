import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Triangle[] triangles = Triangle.fileReader();
        System.out.println("File content:");
        Triangle.printArray(triangles);

        System.out.println("\nPerimeters of triangles:");
        Triangle.printList(Triangle.trianglePerimeter(triangles));

        System.out.println("\nAreas of triangles:");
        Triangle.printList(Triangle.triangleArea(triangles));

        Triangle.typeOfTriangle(triangles);
    }
}