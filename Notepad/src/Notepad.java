import java.io.*;
import java.util.*;

public class Notepad {
    public String text;
    public String font;
    public int fontSize;
    private Date newDate;

    public Notepad(String text, String font, int fontSize) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
    }

    public Notepad() {}

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(List<Notepad> notes, List<Date> dates) {
        int i = 0;
        for (Notepad notepad: notes) {
            notepad.newDate = dates.get(i++);
        }
    }

    public String getText() {
        return text;
    }

    public String getFont() {
        return font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public static void readFile(List<Notepad> notes, List<Date> dates) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isBlank()) {
                String text = line;
                line = bufferedReader.readLine();
                String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                notes.add(new Notepad(text, arrayOfFileLine[0], Integer.parseInt(arrayOfFileLine[1])));
                dates.add(new Date(arrayOfFileLine[2]));
            }
        }
    }

    public void showNotesUsingDate(List<Notepad> notes, Date inputDate) {
        for (Notepad notepad: notes) {
            if (notepad.getNewDate().getDate().equals(inputDate.getDate())) {
                System.out.println(notepad);
            }
        }
    }

    public void print(List<Notepad> notes) {
        for (Notepad notepad: notes) {
            System.out.println(notepad);
        }
    }

    static class Date {
        public String date;

        public Date(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    @Override
    public String toString() {
        return "Notepad {" +
                "text = " + text +
                ", font = " + font +
                ", fontSize = " + fontSize +
                ", date = " + newDate.getDate() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notepad notepad = (Notepad) o;
        return fontSize == notepad.fontSize && Objects.equals(text, notepad.text) && Objects.equals(font, notepad.font) && Objects.equals(newDate, notepad.newDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, font, fontSize, newDate);
    }
}