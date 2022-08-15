import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Notepad> notes = new ArrayList<>();
        List<Notepad.Date> dates = new ArrayList<>();

        Notepad.readFile(notes, dates);

        Notepad notepad = new Notepad();
        notepad.setNewDate(notes, dates);

        notepad.print(notes);

        System.out.println();
        notepad.showNotesUsingDate(notes, new Notepad.Date("01.01.2021")); // for example input date - 01.01.2021
    }
}