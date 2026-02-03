package streamAPI;

import java.util.*;

class Movie {
    String name;
    double rating;

    Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " (" + rating + ")";
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = List.of(
                new Movie("Avengers", 7.5),
                new Movie("Avengers Endgame", 9.0),
                new Movie("Batman", 8.7),
                new Movie("Oppenheimer", 6.9),
                new Movie("Dune", 8.9),
                new Movie("Joker", 8.2),
                new Movie("Thor", 7.9)
        );

        movies.stream().filter(m -> true).sorted((m1, m2) -> Double.compare(m2.rating, m1.rating)).limit(5).forEach(System.out::println);
    }
}
