import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Vector[] vectors = Vector.readFromFile();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFile content:");
        Vector.print(vectors);

        System.out.print("\nConst = ");
        int inputConst = scanner.nextInt();
        for (Vector vector: vectors) {
            System.out.println("\nVector " + vector + ":");
            System.out.println("Module: " + Vector.calcVectorModulus(vector));
            System.out.println("Multiply by const: " + Vector.multiplyByConst(vector, inputConst));
        }

        System.out.print("\nAlpha = ");
        int inputAlpha = scanner.nextInt();

        for (int i = 0; i < vectors.length; i++) {
            for (int j = i + 1; j < vectors.length; j++) {
                System.out.println("\nVectors: " + vectors[i] + ", " + vectors[j] + ":");
                System.out.println("Scalar multiplication: " + Vector.scalarMul(vectors[i], vectors[j], inputAlpha));
                System.out.println("Sum: " + Vector.sumOfVectors(vectors[i], vectors[j]));
                System.out.println("Deduction: " + Vector.deductionOfVectors(vectors[i], vectors[j]));
                System.out.println("Is collinear: " + Vector.isCollinear(vectors[i], vectors[j]));
                System.out.println("Is orthogonal: " + Vector.isOrthogonal(vectors[i], vectors[j]));
            }
        }
    }
}