import java.io.*;
import java.nio.file.*;
import java.util.Objects;

public class TextFile {
    public String name;
    public TextFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(name, textFile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void createFile() throws IOException {
        File file = new File(name);
        if (file.createNewFile()) {
            System.out.println("File " + name + " created");
        }
        else {
            System.out.println("File is already created");
        }
    }

    public void renameFile(String newFileName) throws IOException {
        Path path = Paths.get(name);
        File file = new File(newFileName);
        if (!file.exists()) {
            Files.move(path, path.resolveSibling(String.valueOf(file)));
        }
        else {
            System.out.println("File name " + newFileName + " is already exist");
        }
    }

    public void addTextToFile(String text) throws IOException {
        File file = new File(name);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(text);
        }
    }

    public void showFileContent() throws IOException {
        File file = new File(name);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File" + fileName + "created");
        }
        else {
            System.out.println("File is already created");
        }
    }
}