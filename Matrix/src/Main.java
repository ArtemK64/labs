public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(4, 4);
        Matrix m2 = new Matrix(4, 4);

        System.out.println("\nFirst matrix:");
        Matrix.print(m1);

        System.out.println("\nSecond matrix:");
        Matrix.print(m2);

        System.out.println("\nLogical addition:");
        Matrix.print(Matrix.logicalAddition(m1, m2));

        System.out.println("\nLogical multiply:");
        Matrix.print(Matrix.logicalMultiply(m1, m2));

        System.out.print("\nTotal quantity of 1 for first matrix: ");
        System.out.println(Matrix.countOne(m1));

        System.out.println("\nInverse first matrix:");
        Matrix.print(Matrix.inverseMatrix(m1));

        System.out.println("\nLexicographic order of second matrix: ");
        Matrix.print(Matrix.lexicographyOrder(m2));
    }
}