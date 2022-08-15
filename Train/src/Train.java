import java.io.*;
import java.util.*;

public class Train {
    public String destination;
    public long trainNumber;
    public String departureTime;
    public int[] qtySeats;

    public Train(String destination, long trainNumber, String departureTime, int[] qtySeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.qtySeats = qtySeats;
    }
    public Train() {}

    public String getDestination() {
        return destination;
    }

    public int[] getQtySeats() {
        return qtySeats;
    }

    public long getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setQtySeats(int[] qtySeats) {
        this.qtySeats = qtySeats;
    }

    public void setTrainNumber(long trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Override
    public String toString() {
        return destination + " " +
                trainNumber + " " +
                departureTime + " " +
                Arrays.toString(qtySeats).replaceAll("[,\\[\\]]", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNumber == train.trainNumber &&
                Objects.equals(destination, train.destination) &&
                Objects.equals(departureTime, train.departureTime) &&
                Arrays.equals(qtySeats, train.qtySeats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(destination, trainNumber, departureTime);
        result = 31 * result + Arrays.hashCode(qtySeats);
        return result;
    }

    public static Train[] fileReader(long lines) throws IOException {
        Train[] trains = new Train[(int)lines];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        for (int i = 0; i < lines; i++) {
            String[] arrayOfFileLine = bufferedReader.readLine().split(" ");
            trains[i] = new Train(
                    arrayOfFileLine[0],
                    Long.parseLong(arrayOfFileLine[1]),
                    arrayOfFileLine[2],
                    new int[]{
                            Integer.parseInt(arrayOfFileLine[3]),
                            Integer.parseInt(arrayOfFileLine[4]),
                            Integer.parseInt(arrayOfFileLine[5]),
                            Integer.parseInt(arrayOfFileLine[6])});
        }
        return trains;
    }

    public static List<String> destinationTrains(Train[] trains, String destination) { // list of trains with the same destination
        if (trains == null || trains.length == 0 || destination == null || destination.isEmpty()) {
            return List.of();
        }
        List<String> listOfTrains = new ArrayList<>();
        for (Train train: trains) {
            if (train.destination.equals(destination)) {
                listOfTrains.add(train.toString());
            }
        }
        return listOfTrains;
    }

    public static List<String> destinationTrainsAfterInputTime(Train[] trains, String destination, int hour) {
        // list of trains with the same destination and start after input hour
        if (trains == null || trains.length == 0 || destination == null || destination.isEmpty() || hour < 0) {
            return List.of();
        }
        List<String> listOfTrains = new ArrayList<>();
        for (Train train: trains) {
            if (train.destination.equals(destination) && returnHour(train.departureTime) >= hour) {
                listOfTrains.add(train.toString());
            }
        }
        return listOfTrains;
    }

    public static int returnHour(String time) {
        if (time == null || time.isEmpty()) {
            return 0;
        }
        String[] arrayOfTime = time.split(":");
        return Integer.parseInt(arrayOfTime[0]);
    }

    public static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}