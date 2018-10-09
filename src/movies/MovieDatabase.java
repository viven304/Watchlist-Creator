package movies;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie m) {
        this.movies.add(m);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie searchformoviebyname(String name) {
        Movie result = new Movie(0, "", "");
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                result = m;
            }
        }
        return result;
    }

}

