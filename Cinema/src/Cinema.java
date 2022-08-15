import java.io.*;
import java.util.*;

public class Cinema {
    public String address;
    public String name;
    public Movie movie;

    public Cinema(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public Cinema() {}

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovie(List<Cinema> cinemaList, List<Movie> movies) {
        int i = 0;
        for (Cinema cinema: cinemaList) {
            cinema.movie = movies.get(i++);
        }
    }

    public void readFile(List<Cinema> cinemaList, List<Movie> movies) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            if (!line.isBlank()) {
                String[] arrayOfFileLine = line.replaceAll(" +", " ").split(" ");
                cinemaList.add(new Cinema(arrayOfFileLine[0], arrayOfFileLine[1]));
                movies.add(new Movie(arrayOfFileLine[2], arrayOfFileLine[3]));
            }
        }
    }

    public void print(List<Cinema> cinemaList) {
        for (Cinema cinema: cinemaList) {
            System.out.println(cinema);
        }
    }

    @Override
    public String toString() {
        return "Cinema {" +
                "address = " + address +
                ", name = " + name +
                ", movieTitle = " + movie.getMovieTitle() +
                ", startTime = " + movie.getStartTime() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(address, cinema.address) && Objects.equals(name, cinema.name) && Objects.equals(movie, cinema.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, movie);
    }

    static class Movie {
        public String movieTitle;
        public String startTime;

        public Movie(String movieTitle, String startTime) {
            this.movieTitle = movieTitle;
            this.startTime = startTime;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }
}