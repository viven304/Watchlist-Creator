package model;

import exceptions.AlreadyInWatchlist;

import java.io.IOException;

public interface Load {
    public void load(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase, String filename) throws IOException, AlreadyInWatchlist;
}
