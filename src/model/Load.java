package model;

import exceptions.AlreadyInWatchlistException;

import java.io.IOException;

public interface Load {
    public void load(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase, String filename) throws IOException, AlreadyInWatchlistException;
}
