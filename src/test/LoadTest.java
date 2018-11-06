//package test;
//
//import model.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class LoadTest {
//    Watchlist watchlist = new Watchlist();
//    MovieDatabase movieDatabase = new MovieDatabase();
//    Movie conjuring = new Movie(86, "Conjuring", "Genre");
//    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
//    TVShow twd = new TVShow(86, "The Walking Dead", "Horror");
//    TVShow got = new TVShow(95, "Game of Thrones", "Fantasy");
//    TVShowDatabase tvShowDatabase = new TVShowDatabase();
//
//
//    @BeforeEach
//    public void runPrior() {
//        movieDatabase.addMovie(conjuring);
//        movieDatabase.addMovie(interstellar);
//        tvShowDatabase.addTVShow(twd);
//        tvShowDatabase.addTVShow(got);
//    }
//
//    @Test
//    public void testLoadEmptyFile() throws IOException {
//        watchlist.load(movieDatabase, tvShowDatabase, "testemptyfile.txt");
//        assertEquals(0, watchlist.getTitles().size());
//    }
//
//    @Test
//    public void testLoadOneMovie() throws IOException {
//        watchlist.load(movieDatabase, tvShowDatabase, "testonemovie.txt");
//        assertEquals(1, watchlist.getTitles().size());
//    }
//
//    @Test
//    public void testLoadTwoMoviesOneIsNotInDatabase() throws IOException {
//        watchlist.load(movieDatabase, tvShowDatabase, "testtwomoviesonenotinmd.txt");
//        assertEquals(1, watchlist.getTitles().size());
//    }
//
//    @Test
//    public void testLoadTwoMoviesBothInDatabase() throws IOException {
//        watchlist.load(movieDatabase, tvShowDatabase, "testtwomoviesbothinmd.txt");
//        assertEquals(2, watchlist.getTitles().size());
//    }
//
//    @Test
//    public void testLoadTwoMoviesNoneInDatabase() throws IOException {
//        watchlist.load(movieDatabase, tvShowDatabase, "testtwomoviesbothnotinmd.txt");
//        assertEquals(0, watchlist.getTitles().size());
//    }
//
//
//}
