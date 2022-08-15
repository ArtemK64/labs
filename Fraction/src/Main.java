import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Fraction[] fractions = Fraction.readFromFile();
        Fraction.printFractions(Fraction.addNextValue(fractions));
    }
}