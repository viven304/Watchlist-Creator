package ui;

import exceptions.AlreadyInWatchlistException;
import model.*;

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
        movieDatabase.addObserver(conjuring);
        movieDatabase.addObserver(interstellar);
        movieDatabase.addTitleToDatabase(conjuring);
        movieDatabase.addTitleToDatabase(interstellar);

        Scanner scanner = new Scanner(System.in);
        twdeps.add(negan);
        twdeps.add(welost);
        twd.setEpisodes("5",twdeps);
        goteps.add(bob);
        got.setEpisodes("6", goteps);
        tvShowDatabase.addObserver(twd);
        tvShowDatabase.addObserver(got);

        tvShowDatabase.addTitleToDatabase(twd);
        tvShowDatabase.addTitleToDatabase(got);

        String choice = "";
        while (true) {
            System.out.println("Choose");
            System.out.println("[1] Load Watchlist [2] New Watchlist [3] quit");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                try {
                    watchlist.load(movieDatabase, tvShowDatabase, "inputfile.txt");
                } catch (AlreadyInWatchlistException alreadyInWatchlistException) {
                }
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






