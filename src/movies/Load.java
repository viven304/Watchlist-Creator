package movies;

import exceptions.AlreadyInWatchlist;
import movies.MovieDatabase;
import movies.Watchlist;

import java.io.IOException;

public interface Load {
    public void load(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase, String filename) throws IOException, AlreadyInWatchlist;
}
