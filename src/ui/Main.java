package ui;

import movies.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main{
    Scanner scanner = new Scanner(System.in);
    Movie conjuring = new Movie(86, "Conjuring", "Genre");
    Genre horror = new Genre();
    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
    Genre scifi = new Genre();
    MovieDatabase movieDatabase = new MovieDatabase();
    Watchlist watchlist = new Watchlist();
    TVShow twd = new TVShow(86, "The Walking Dead", "Horror");
    ArrayList<Episode> twdeps = new ArrayList<>();
    Episode negan = new Episode(80, "Negan", "Horror");
    Episode welost = new Episode(70, "We Lost", "Horror");
    TVShow got = new TVShow(95, "Game of Thrones", "Fantasy");
    ArrayList<Episode> goteps = new ArrayList<>();
    Episode bob = new Episode(99, "Battle of Bastards", "Fantasy");
    TVShowDatabase tvShowDatabase = new TVShowDatabase();

    public Main() throws IOException{
        movieDatabase.addMovie(conjuring);
        movieDatabase.addMovie(interstellar);
        Scanner scanner = new Scanner(System.in);
        twdeps.add(negan);
        twdeps.add(welost);
        twd.setEpisodes(twdeps);
        goteps.add(bob);
        got.setEpisodes(goteps);
        tvShowDatabase.addTVShow(twd);
        tvShowDatabase.addTVShow(got);
        String choice = "";
        while (true) {
            System.out.println("Choose");
            System.out.println("[1] Load Watchlist [2] New Watchlist [3] quit");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                watchlist.load(movieDatabase, tvShowDatabase, "inputfile.txt");
                watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);
            } else if (choice.equals("2")) {
                watchlist.namingWatchlist();
                watchlist.addingTitlesToWatchlistLoop(movieDatabase, tvShowDatabase);
            }
            else if (choice.equals("3")) {
                break;
            }
        }
        watchlist.save("inputfile.txt");
        System.out.println("thanks for using the WatchListCreator");
    }





    public static void main(String[] args) throws IOException {
        new Main();
    }
}






