package model;

import java.util.ArrayList;


public class Genre {
    public ArrayList<VisualEntertainment> GenreMovies = new ArrayList<>();
    public String genreName;

    public void Genre(String genreName, ArrayList<VisualEntertainment> GenreMovies) {
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




