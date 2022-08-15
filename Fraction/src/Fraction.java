import java.io.*;
import java.nio.file.*;
import java.util.Objects;
import java.util.stream.Stream;

public class Fraction {
    public long m;
    public long n;

    public Fraction(long m, long n) {
        this.m = m;
        this.n = n;
    }

    public Fraction() {}

    public double getM() {
        return m;
    }

    public double getN() {
        return n;
    }

    public void setM(long m) {
        this.m = m;
    }

    public void setN(long n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return m + "/" + n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return m == fraction.m && n == fraction.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, n);
    }

    public static Fraction[] readFromFile() throws IOException {
        long k;
        try (Stream<String> stream = Files.lines(Path.of("input.txt"))) {
            k = stream.count();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        Fraction[] fractions = new Fraction[(int)k];

        for (int i = 0; i < k; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            fractions[i] = new Fraction(Long.parseLong(arrayOfFileLine[0]), Long.parseLong(arrayOfFileLine[1]));
        }
        return fractions;
    }
    public static Fraction[] addNextValue(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i++) {
            if (i % 2 == 0) {
                long temp = fractions[i].n;
                fractions[i].m = fractions[i].m * fractions[i + 1].n;
                fractions[i].n = fractions[i].n * fractions[i + 1].n;

                fractions[i + 1].m = fractions[i + 1].m * temp;
                fractions[i + 1].n = fractions[i + 1].n * temp;

                fractions[i].m = fractions[i].m + fractions[i + 1].m;
            }
            long divisor = greatestCommonDivisor(fractions[i].m, fractions[i].n);
            fractions[i].m /= divisor;
            fractions[i].n /= divisor;
        }
        return fractions;
    }

    public static long greatestCommonDivisor(long m, long n) {
        if (n == 0) {
            return m;
        }
        return greatestCommonDivisor(n, m % n);
    }

    public static void printFractions(Fraction[] fractions) {
        for (Fraction fraction: fractions) {
            System.out.println(fraction.toString());
        }
    }
}