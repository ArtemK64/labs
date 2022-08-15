import java.io.*;
import java.util.*;

public class Mobile {
    public String type;
    private PhoneInformation phoneInformation;

    public Mobile(String type) {
        this.type = type;
    }

    public Mobile() {}

    public String getType() {
        return type;
    }

    public PhoneInformation getPhoneInformation() {
        return phoneInformation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneInformation(List<Mobile> mobiles, List<PhoneInformation> phoneInformationList) {
        int i = 0;
        for (Mobile mobile: mobiles) {
            mobile.phoneInformation = phoneInformationList.get(i++);
        }
    }

    @Override
    public String toString() {
        return "Mobile {" +
                "type = " + type +
                ", brand = " + phoneInformation.getBrand() +
                ", camera = " + phoneInformation.getCamera() +
                ", display = " + phoneInformation.getDisplay() +
                ", color = " + phoneInformation.getColor() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return Objects.equals(type, mobile.type) && Objects.equals(phoneInformation, mobile.phoneInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, phoneInformation);
    }

    public void readFile(List<Mobile> mobiles, List<PhoneInformation> phoneInformationList) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isBlank()) {
                String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                mobiles.add(new Mobile(arrayOfFileLine[0]));
                phoneInformationList.add(new PhoneInformation(arrayOfFileLine[1], Integer.parseInt(arrayOfFileLine[2]), arrayOfFileLine[3], arrayOfFileLine[4]));
            }
        }
    }

    public <T> void print(List<T> list) {
        for (T t: list) {
            System.out.println(t);
        }
    }

    static class PhoneInformation {
        public String brand;
        public int camera;
        public String display;
        public String color;

        public PhoneInformation(String brand, int camera, String display, String color) {
            this.brand = brand;
            this.camera = camera;
            this.display = display;
            this.color = color;
        }

        public String getBrand() {
            return brand;
        }

        public int getCamera() {
            return camera;
        }

        public String getDisplay() {
            return display;
        }

        public String getColor() {
            return color;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setCamera(int camera) {
            this.camera = camera;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}