package movies;

import java.util.ArrayList;


public class Genre {
    public ArrayList<Movie> GenreMovies = new ArrayList<>();
    public String genreName;

    public void Genre(String genreName, ArrayList<Movie> GenreMovies) {
        this.genreName = genreName;
        this.GenreMovies = GenreMovies;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
    public void addMovie(Movie m) {
        this.GenreMovies.add(m);
    }
}




