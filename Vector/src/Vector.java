import java.io.*;
import java.util.*;

public class Vector {
    public double x;
    public double y;
    public double z;

    public Vector (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + ", " + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.x, x) == 0 && Double.compare(vector.y, y) == 0 && Double.compare(vector.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
    public static Vector[] readFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        List<Vector> vectors = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arrayOfFileLine = line.split(" ");
            Vector vector = new Vector(
                    Double.parseDouble(arrayOfFileLine[0]),
                    Double.parseDouble(arrayOfFileLine[1]),
                    Double.parseDouble(arrayOfFileLine[2]));
            vectors.add(vector);
        }
        return vectors.toArray(Vector[]::new);
    }

    public static double calcVectorModulus(Vector vector) {
        if (vector == null) {
            return 0;
        }
        return Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2));
    }

    public static double scalarMul(Vector v1, Vector v2, int alpha) {
        if (v1 == null || v2 == null || alpha < 0) {
            return 0;
        }
        double toRadiansDegree = Math.toRadians(alpha);
        return calcVectorModulus(v1) * calcVectorModulus(v2) * Math.cos(toRadiansDegree);
    }

    public static Vector sumOfVectors(Vector v1, Vector v2) {
        if (v1 == null && v2 == null) {
            return new Vector(0, 0, 0);
        }
        else if (v1 == null) {
            return v2;
        }
        else if (v2 == null) {
            return v1;
        }
        return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static Vector deductionOfVectors(Vector v1, Vector v2) {
        if (v1 == null && v2 == null) {
            return new Vector(0, 0, 0);
        }
        else if (v1 == null) {
            return new Vector(v2.x * (-1), v2.y * (-1), v2.z * (-1));
        }
        else if (v2 == null) {
            return v1;
        }
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static Vector multiplyByConst(Vector vector, int constant) {
        if (vector == null) {
            return new Vector(0, 0, 0);
        }
        return new Vector(vector.x * constant, vector.y * constant, vector.z * constant);
    }

    public static boolean isCollinear(Vector v1, Vector v2) {
        if (v1 == null || v2 == null) {
            return false;
        }
        if (v1.x == 0 || v2.x == 0) {
            return v1.y / v2.y == v1.z / v2.z;
        }
        else if (v1.y == 0 || v2.y == 0) {
            return v1.x / v2.x == v1.z / v2.z;
        }
        else if (v1.z == 0 || v2.z == 0) {
            return v1.x / v2.x == v1.y / v2.y;
        }
        else {
            return v1.x / v2.x == v1.y / v2.y && v1.y / v2.y == v1.z / v2.z;
        }
    }
    public static boolean isOrthogonal(Vector v1, Vector v2) {
        if (v1 == null || v2 == null) {
            return false;
        }
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z == 0;
    }

    public static void print(Vector[] vectors) {
        for (Vector vector: vectors) {
            System.out.println(vector);
        }
    }
}