import java.io.*;
import java.util.*;

public class TableLamp extends Lamp implements LightSource {
    public String typeOfBracing;

    public TableLamp(String typeOfLightBulb, int price, String typeOfBracing) {
        super(typeOfLightBulb, price);
        this.typeOfBracing = typeOfBracing;
    }

    public TableLamp() {}

    public String getTypeOfBracing() {
        return typeOfBracing;
    }

    public void setTypeOfBracing(String typeOfBracing) {
        this.typeOfBracing = typeOfBracing;
    }

    @Override
    public String toString() {
        return "TableLamp {" +
                "typeOfLightBulb = " + typeOfLightBulb +
                ", price = " + price +
                ", typeOfBracing = " + typeOfBracing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TableLamp tableLamp = (TableLamp) o;
        return Objects.equals(typeOfBracing, tableLamp.typeOfBracing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfBracing);
    }

    public void fileReader(List<Lamp> lamps, List<TableLamp> tableLamps) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine().toLowerCase()) {
            case "lamp":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        if (arrayOfFileLine.length == 1) {
                            break;
                        }
                        lamps.add(new Lamp(arrayOfFileLine[0], Integer.parseInt(arrayOfFileLine[1])));
                    }
                }
            case "tablelamp":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                        if (arrayOfFileLine.length == 1) {
                            break;
                        }
                        tableLamps.add(new TableLamp(arrayOfFileLine[0], Integer.parseInt(arrayOfFileLine[1]), arrayOfFileLine[2]));
                    }
                }
        }
    }

    public void turnOn() {
        System.out.println("The lamp was on");
    }

    public void turnOff() {
        System.out.println("The lamp was off");
    }

    public void changeLightBulb() {
        System.out.println("The light bulb was changed");
    }

    public void relocateLamp() {
        System.out.println("The lamp was relocated");
    }

    public <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}