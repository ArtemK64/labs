import java.util.Arrays;

public class Matrix {
    public int[][] matrix;

    public Matrix(int rows, int columns) {
        if (rows < 0 || columns < 0) {
            throw new ArrayIndexOutOfBoundsException("Negative index");
        }
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int)Math.round(Math.random());
            }
        }
    }

    public int getVerticalSize() {
        return matrix.length;
    }

    public int getHorizontalSize() {
        return matrix[0].length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getVerticalSize(); i++) {
            for (int j = 0; j < getHorizontalSize(); j++) {
                stringBuilder.append(matrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    public static Matrix logicalAddition(Matrix m1, Matrix m2) {
        checkMatrix(m1, m2);
        Matrix resultMatrix = new Matrix(m1.getVerticalSize(), m1.getHorizontalSize());
        for (int i = 0; i < resultMatrix.getVerticalSize(); i++) {
            for (int j = 0; j < resultMatrix.getHorizontalSize(); j++) {
                if (m1.matrix[i][j] == 0 && m2.matrix[i][j] == 0) {
                    resultMatrix.matrix[i][j] = 0;
                }
                else {
                    resultMatrix.matrix[i][j] = 1;
                }
            }
        }
        return resultMatrix;
    }

    public static Matrix logicalMultiply(Matrix m1, Matrix m2) {
        checkMatrix(m1, m2);
        Matrix resultMatrix = new Matrix(m1.getVerticalSize(), m1.getHorizontalSize());
        for (int i = 0; i < m1.getVerticalSize(); i++) {
            for (int j = 0; j < m1.getHorizontalSize(); j++) {
                if (m1.matrix[i][j] == 1 && m2.matrix[i][j] == 1) {
                    resultMatrix.matrix[i][j] = 1;
                }
                else {
                    resultMatrix.matrix[i][j] = 0;
                }
            }
        }
        return resultMatrix;
    }

    public static Matrix inverseMatrix(Matrix m) {
        for (int i = 0; i < m.getVerticalSize(); i++) {
            for (int j = 0; j < m.getHorizontalSize(); j++) {
                if (m.matrix[i][j] == 0) {
                    m.matrix[i][j] = 1;
                }
                else {
                    m.matrix[i][j] = 0;
                }
            }
        }
        return m;
    }

    public static int countOne(Matrix m) {
        int count = 0;
        for (int i = 0; i < m.getVerticalSize(); i++) {
            for (int j = 0; j < m.getHorizontalSize(); j++) {
                if (m.matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Matrix lexicographyOrder(Matrix m) {
        for (int i = 0; i < m.getVerticalSize(); i++) {
            Arrays.sort(m.matrix[i]);
        }
        for (int i = 0; i < m.getVerticalSize() - 1; i++) {
            if (Arrays.stream(m.matrix[i]).sum() > Arrays.stream(m.matrix[i + 1]).sum()) {
                int[] temp = m.matrix[i];
                m.matrix[i] = m.matrix[i + 1];
                m.matrix[i + 1] = temp;
            }
        }
        return m;
    }

    public static void checkMatrix(Matrix m1, Matrix m2) {
        if (m1.getHorizontalSize() != m1.getVerticalSize() || m2.getHorizontalSize() != m2.getVerticalSize()) {
            throw new ArrayIndexOutOfBoundsException("Matrix index out of bounds");
        }
    }

    public static void print(Matrix m) {
        for (int i = 0; i < m.getVerticalSize(); i++) {
            for (int j = 0; j < m.getHorizontalSize(); j++) {
                System.out.print(m.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}