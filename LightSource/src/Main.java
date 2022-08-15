import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<TableLamp> tableLamps = new ArrayList<>();
        List<Lamp> lamps = new ArrayList<>();

        TableLamp tableLamp = new TableLamp();
        tableLamp.fileReader(lamps, tableLamps);

        tableLamp.print(tableLamps);
        tableLamp.print(lamps);

        System.out.println();
        tableLamp.turnOn();
        tableLamp.turnOff();
        tableLamp.changeLightBulb();
        tableLamp.relocateLamp();
    }
}