package movies;

import java.time.LocalDate;
import java.util.ArrayList;


public class Movie {
    private float rating;
    private String name;
    private String genre;
    private ArrayList<String> watchlists;
    private LocalDate datewatched;

    public Movie(int rating, String name, String genre) {
        this.rating = rating;
        this.name = name;
        this.genre = genre;
        this.watchlists = new ArrayList<String>();
        this.datewatched = LocalDate.now();
    }

    // EFFECTS: gets the rating of the movie
    public float getRating() {
        return this.rating;
    }

    // EFFECTS: gets the genre of the movie
    public String getGenre() {
        return this.genre;
    }

    // EFFECTS: gets the genre of the movie
     public String getName() {
         return this.name;
    }

    // EFFECTS: gets the watchlists the movie is part of
    public ArrayList<String> getWatchlists() {
        return this.watchlists;
    }

    public void addWatchlistName(String watchlistname) {
        this.watchlists.add(watchlistname);
    }

    public void changeDateWatched(LocalDate localdate) {
        this.datewatched = localdate;
    }



public void print() {
    System.out.println(name + " has a rating of " + rating);
}

}
