package test;

import movies.Movie;
import movies.Watchlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WatchlistTest {

    private Watchlist watchlist;
    private Movie jackie;
    private Movie wackie;

    @BeforeEach
    public void runPrior() {
        watchlist = new Watchlist();
        watchlist.setName("TestWatchlist");

        jackie = new Movie(68, "Jackie", "Unknown");
        wackie = new Movie(55, "Wackie", "You don't wanna know");
    }

    @Test
    public void testaddMovie() {
        watchlist.addMovie(jackie);
        assertEquals(1, watchlist.getMovies().size());
        assertTrue(watchlist.getMovies().contains(jackie));
        assertTrue(jackie.getWatchlists().contains("TestWatchlist"));
        assertEquals(1, jackie.getWatchlists().size());
        assertTrue(LocalDate.now() == watchlist.getLastmodified());
    }

    @Test
    public void testRemove() {
        watchlist.addMovie(jackie);
        watchlist.removeMovie(jackie);
        assertEquals(0, watchlist.getMovies().size());
        assertFalse(watchlist.getMovies().contains(jackie));
        assertFalse(jackie.getWatchlists().contains("TestWatchlist"));
        assertTrue(LocalDate.now() == watchlist.getLastmodified());
    }



    @Test
    public void testSameMovieTwice() {
        watchlist.addMovie(jackie);
        watchlist.addMovie(jackie);
        assertEquals(1, watchlist.getMovies().size());
        assertTrue(jackie.getWatchlists().contains("TestWatchlist"));
        assertEquals(1,jackie.getWatchlists().size());
        assertFalse(LocalDate.now() == watchlist.getLastmodified());
    }

    @Test
    public void testDiffMovies() {
        watchlist.addMovie(jackie);
        watchlist.addMovie(wackie);
        assertEquals(2, watchlist.getMovies().size());
        assertTrue(jackie.getWatchlists().contains("TestWatchlist"));
        assertTrue(wackie.getWatchlists().contains("TestWatchlist"));
        assertTrue(LocalDate.now() == watchlist.getLastmodified());

    }


    }

