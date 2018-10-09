package movies;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class VisualEntertainment {
    protected float rating;
    protected String name;
    protected String genre;
    protected ArrayList<String> watchlists;
    protected LocalDate datewatched;

    public VisualEntertainment(float rating, String name, String genre) {
        this.datewatched = LocalDate.now();
        this.watchlists = new ArrayList<String>();
        this.rating = rating;
        this.name = name;
        this.genre = genre;
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

    public void changeDateWatched(LocalDate localdate) {
        this.datewatched = localdate;
    }

    public void setWatchlist(String name) {
        this.watchlists.add(name);
    }

    public void removeWatchlist(String name) {
        this.watchlists.remove(name);
    }

    protected abstract void displaydetails();

    public Boolean isInWatchlist(String watchlistname) {
        return this.watchlists.contains(watchlistname);
    }


}
