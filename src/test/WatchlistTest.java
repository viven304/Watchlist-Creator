package test;

import movies.Movie;
import movies.Watchlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WatchlistTest {

    private Watchlist watchlist;
    private Movie jackie;
    private Movie wackie;
    private Movie abcd;
    private Movie zzzz;
    private Movie joe;

    @BeforeEach
    public void runPrior() {
        watchlist = new Watchlist();

        jackie = new Movie(68, "Jackie", "Unknown");
        wackie = new Movie(55, "Wackie", "You don't wanna know");
        abcd = new Movie(12, "ABCD", "Kindergarten Curriculum");
        zzzz = new Movie(100, "ZZZZ", "Heaven");
        joe = new Movie(20, "Joe", "Where?");
    }

    @Test
    public void testConstructor(){
        assertEquals(0 ,watchlist.getTitles().size());
    }

    @Test
    public void testsetName() {
        watchlist.setName("TestWatchlist");
        assertTrue("TestWatchlist" == watchlist.getWatchlistName());
    }

    @Test
    public void testaddMovie() {
        watchlist.setName("TestWatchlist");
        watchlist.addTitle(jackie);

        assertEquals(1, watchlist.getTitles().size());
        assertTrue(watchlist.getTitles().contains(jackie));
    }

    @Test
    public void testRemove() {
        watchlist.setName("TestWatchlist");
        watchlist.addTitle(jackie);
        watchlist.removeTitle(jackie);

        assertEquals(0, watchlist.getTitles().size());
        assertFalse(watchlist.getTitles().contains(jackie));
    }



    @Test
    public void testSameMovieTwice() {
        watchlist.setName("TestWatchlist");
        watchlist.addTitle(jackie);
        watchlist.addTitle(jackie);

        assertEquals(1, watchlist.getTitles().size());
    }

    @Test
    public void testDiffMovies() {
        watchlist.setName("TestWatchlist");
        watchlist.addTitle(jackie);
        watchlist.addTitle(wackie);

        assertEquals(2, watchlist.getTitles().size());
    }

    @Test
    public void testSortAlphabeticallyOneMovie() {
        watchlist.addTitle(jackie);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(jackie ==watchlist.getTitles().get(0));
    }

    @Test
    public void testSortAlphabeticallyTwoMoviesDiffAlphabets() {
        watchlist.addTitle(jackie);
        watchlist.addTitle(wackie);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(jackie ==watchlist.getTitles().get(0));
    }
    @Test
    public void testSortAlphabeticallyTwoMoviesSameAlphabets() {
        watchlist.addTitle(jackie);
        watchlist.addTitle(joe);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(joe == watchlist.getTitles().get(0));
    }


    @Test
    public void testSortAlphMultipleMoviesOppositeOrder() {
        watchlist.addTitle(abcd);
        watchlist.addTitle(jackie);
        watchlist.addTitle(wackie);
        watchlist.addTitle(zzzz);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(abcd == watchlist.getTitles().get(0));
        assertTrue(jackie == watchlist.getTitles().get(1));
        assertTrue(jackie == watchlist.getTitles().get(2));
        assertTrue(zzzz == watchlist.getTitles().get(3));

    }

    @Test
    public void testSortAlphMultipleMoviesCorrectOrder() {
        watchlist.addTitle(zzzz);
        watchlist.addTitle(wackie);
        watchlist.addTitle(jackie);
        watchlist.addTitle(abcd);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(abcd == watchlist.getTitles().get(0));
        assertTrue(jackie == watchlist.getTitles().get(1));
        assertTrue(jackie == watchlist.getTitles().get(2));
        assertTrue(zzzz == watchlist.getTitles().get(3));

    }

    @Test
    public void testSortAlphMultipleMoviesJumbled() {
        watchlist.addTitle(jackie);
        watchlist.addTitle(zzzz);
        watchlist.addTitle(abcd);
        watchlist.addTitle(wackie);
        watchlist.sortWatchlistAlphabetically();

        assertTrue(abcd == watchlist.getTitles().get(0));
        assertTrue(jackie == watchlist.getTitles().get(1));
        assertTrue(jackie == watchlist.getTitles().get(2));
        assertTrue(zzzz == watchlist.getTitles().get(3));

    }


    }

