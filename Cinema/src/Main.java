import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Cinema> cinemaList = new ArrayList<>();
        List<Cinema.Movie> movies = new ArrayList<>();

        Cinema cinema = new Cinema();
        cinema.readFile(cinemaList, movies);

        cinema.setMovie(cinemaList, movies);

        cinema.print(cinemaList);
    }
}