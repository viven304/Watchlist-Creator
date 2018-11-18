package model;

import exceptions.AlreadyInWatchlistException;
import exceptions.NotInTheWatchlistException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class VisualEntertainment implements AbstractObserver {
    protected float rating;
    protected String name;
    protected String genre;
    protected ArrayList<Watchlist> watchlists;
    protected LocalDate datewatched;

    public VisualEntertainment(float rating, String name, String genre) {
        this.datewatched = LocalDate.now();
        this.watchlists = new ArrayList<Watchlist>();
        this.rating = rating;
        this.name = name;
        this.genre = genre;
    }

    public Map<String, List<Episode>> getEpisodes() {return null;};

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
    public ArrayList<Watchlist> getWatchlists() {
        return this.watchlists;
    }

    public void changeDateWatched(LocalDate localdate) {
        this.datewatched = localdate;
    }

    public void addWatchlist(Watchlist watchlist) throws AlreadyInWatchlistException {
        if (!(watchlists.contains(watchlist))) {
            watchlists.add(watchlist);
        }
            else {
            throw new AlreadyInWatchlistException();
            }
        }

    public void removeWatchlist(Watchlist watchlist) throws NotInTheWatchlistException {
        if (!(watchlists.contains(watchlist))) {
            watchlists.remove(watchlist);
        }
            else {
                throw new NotInTheWatchlistException();
            }
    }

    public float howFarAlong(Watchlist watchlist){return 0;}

    public void displaydetails() {
        System.out.println("Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
    }

    public Boolean isInWatchlist(String watchlistname) {
        return this.watchlists.contains(watchlistname);
    }

}
