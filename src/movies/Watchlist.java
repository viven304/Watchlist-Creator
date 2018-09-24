package movies;

import sun.plugin.javascript.navig.Array;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Watchlist {
    private String name;
    private ArrayList<Movie> movies;
    private LocalDate lastmodified;

    // EFFECTS: creates a new watchlist with given name
    public void Watchlist(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.lastmodified = LocalDate.now();
    }

    // EFFECTS: gets watchlist's name
    public String getWatchlistName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // EFFECTS: gets watchlist's movies
    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public LocalDate getLastmodified() {
        return this.lastmodified;
    }

    // MODIFIES: this and movie
    // EFFECTS: it adds the movie to the watchlist
    //          and adds the watchlist's name to the movie
    //          if movie already added do nothing
    //          updates last modified to current date
    public void addMovie(Movie movie) {
        //
    }


    // REQUIRES: a movie that is already in the watchlist
    // MODIFIES: this and movie
    // EFFECTS: it removes the movie from the watchlist
    //          and removes the watchlist from the movie
    //          updates last modified to current date
    public void removeMovie(Movie movie) {
        //
    }

    // REQUIRES: a watchlist that is not empty
    // EFFECTS: prints the names of the movies
    public void printWatchlist() {
        //
    }






}
