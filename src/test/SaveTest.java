package test;

import movies.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveTest {
    Watchlist watchlist = new Watchlist();
    MovieDatabase movieDatabase = new MovieDatabase();
    Movie conjuring = new Movie(86, "Conjuring", "Genre");
    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
    TVShow twd = new TVShow(86, "The Walking Dead", "Horror");
    TVShow got = new TVShow(95, "Game of Thrones", "Fantasy");
    TVShowDatabase tvShowDatabase = new TVShowDatabase();


    @BeforeEach
    public void runPrior() {
        movieDatabase.addMovie(conjuring);
        movieDatabase.addMovie(interstellar);
        tvShowDatabase.addTVShow(twd);
        tvShowDatabase.addTVShow(got);
    }

    @Test
    public void testSaveNothing() throws IOException {
        watchlist.save("testsave.txt");
        watchlist.load(movieDatabase, tvShowDatabase, "testsave.txt");
        assertEquals(0, watchlist.getTitles().size());
    }


    @Test
    public void testSaveOneMovie() throws IOException {
        watchlist.addTitle(conjuring);
        watchlist.save("testsave.txt");
        watchlist.load(movieDatabase, tvShowDatabase, "testsave.txt");
        assertEquals(1, watchlist.getTitles().size());
    }


    @Test
    public void testSaveTwoMovies() throws IOException {
        watchlist.addTitle(conjuring);
        watchlist.addTitle(interstellar);
        watchlist.save("testsave.txt");
        watchlist.load(movieDatabase, tvShowDatabase, "testsave.txt");
        assertEquals(2, watchlist.getTitles().size());
    }

}
