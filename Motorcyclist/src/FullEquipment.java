import java.io.*;
import java.util.*;

public class FullEquipment {
    public Helmet helmet;
    public Gloves gloves;
    public Boots boots;
    public Jumpsuit jumpsuit;

    public FullEquipment(Helmet helmet, Gloves gloves, Boots boots, Jumpsuit jumpsuit) {
        this.helmet = helmet;
        this.gloves = gloves;
        this.boots = boots;
        this.jumpsuit = jumpsuit;
    }

    public int getHelmetPrice() {
        return helmet.price;
    }

    public int getGlovesPrice() {
        return gloves.price;
    }

    public int getBootsPrice() {
        return boots.price;
    }

    public int getJumpsuitPrice() {
        return jumpsuit.price;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setGloves(Gloves gloves) {
        this.gloves = gloves;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public void setJumpsuit(Jumpsuit jumpsuit) {
        this.jumpsuit = jumpsuit;
    }

    @Override
    public String toString() {
        return "FullEquipment {" +
                "\n\thelmet = " + helmet + ", " +
                "\n\tgloves = " + gloves + ", " +
                "\n\tboots = " + boots + ", " +
                "\n\tjumpsuit = " + jumpsuit +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullEquipment that = (FullEquipment) o;
        return Objects.equals(helmet, that.helmet) && Objects.equals(gloves, that.gloves) && Objects.equals(boots, that.boots) && Objects.equals(jumpsuit, that.jumpsuit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(helmet, gloves, boots, jumpsuit);
    }

    public static void readFile(List<Helmet> helmetList, List<Gloves> glovesList, List<Boots> bootsList, List<Jumpsuit> jumpsuitList) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        switch (bufferedReader.readLine().toLowerCase()) {
            case "helmet":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        helmetList.add(new Helmet(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Double.parseDouble(arrayOfFileLine[2]),
                                Boolean.parseBoolean(arrayOfFileLine[3])
                        ));
                    }
                }
            case "gloves":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        glovesList.add(new Gloves(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Double.parseDouble(arrayOfFileLine[2]),
                                arrayOfFileLine[3]
                        ));
                    }
                }
            case "boots":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        bootsList.add(new Boots(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Double.parseDouble(arrayOfFileLine[2]),
                                arrayOfFileLine[3]
                        ));
                    }
                }
            case "jumpsuit":
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isBlank()) {
                        if (line.split(" ").length == 1) {
                            break;
                        }
                        String[] arrayOfFileLine = line.split(" ");
                        jumpsuitList.add(new Jumpsuit(
                                Integer.parseInt(arrayOfFileLine[0]),
                                arrayOfFileLine[1],
                                Double.parseDouble(arrayOfFileLine[2]),
                                arrayOfFileLine[3]
                        ));
                    }
                }
        }
    }

    public static FullEquipment equipMotorcyclist(Helmet helmet, Gloves gloves, Boots boots, Jumpsuit jumpsuit) {
        return new FullEquipment(helmet, gloves, boots, jumpsuit);
    }

    public static int equipmentPrice(FullEquipment fullEquipment) {
        return fullEquipment.getHelmetPrice() + fullEquipment.getGlovesPrice() + fullEquipment.getBootsPrice() + fullEquipment.getJumpsuitPrice();
    }

    public static void itemsPriceInterval(FullEquipment fullEquipment, int startPrice, int endPrice) {
        if (startPrice < fullEquipment.getHelmetPrice() && fullEquipment.getHelmetPrice() < endPrice) {
            System.out.println(fullEquipment.helmet);
        }
        if (startPrice < fullEquipment.getBootsPrice() && fullEquipment.getBootsPrice() < endPrice) {
            System.out.println(fullEquipment.boots);
        }
        if (startPrice < fullEquipment.getGlovesPrice() && fullEquipment.getGlovesPrice() < endPrice) {
            System.out.println(fullEquipment.gloves);
        }
        if (startPrice < fullEquipment.getJumpsuitPrice() && fullEquipment.getJumpsuitPrice() < endPrice) {
            System.out.println(fullEquipment.jumpsuit);
        }
    }

    public static <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }
}