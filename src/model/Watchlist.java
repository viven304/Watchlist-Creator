package model;

import exceptions.AlreadyInWatchlistException;
import exceptions.NotInTheWatchlistException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Watchlist extends Subject implements Load, Save {
    private String name;
    private ArrayList<VisualEntertainment> list = new ArrayList<>();
    private LocalDate lastmodified;

    // EFFECTS: creates a new watchlistinput with given name
    public void Watchlist(String name) throws IOException {
        this.name = name;
        this.lastmodified = LocalDate.now();
    }

    // EFFECTS: gets watchlistinput's name
    public String getWatchlistName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // EFFECTS: gets watchlistinput's model
    public ArrayList<VisualEntertainment> getTitles() {
        return this.list;
    }


    // EFFECTS: gets watchlistinput's last modified date
    public LocalDate getLastmodified() {
        return this.lastmodified;
    }

    // MODIFIES: this and movie
    // EFFECTS: it adds the movie to the watchlist only if the movie's name is not an empty string
    //          and adds the watchlistinput's name to the movie
    //          if movie already added do nothing
    //          updates last modified to current date
    public void addTitle(VisualEntertainment title) throws AlreadyInWatchlistException {
        if (!(title == null)) {
            if (!(this.list.contains(title))) {
                this.list.add(title);
                title.addWatchlist(this);
            }
            else {
                throw new AlreadyInWatchlistException();
            }
        }
    }


    // REQUIRES: a movie that is already in the watchlistinput
    // MODIFIES: this and movie
    // EFFECTS: it removes the movie from the watchlistinput
    //          and removes the watchlistinput from the movie
    //          updates last modified to current date
    public void removeTitle(VisualEntertainment title) throws NotInTheWatchlistException {
        if (this.list.contains(title)) {
            this.list.remove(title);
            title.removeWatchlist(this);
        } else {
            throw new NotInTheWatchlistException();
        }
    }


    public ArrayList<String> printTitlesWithSpace() {
        String result = "";
        for (VisualEntertainment t : list) {
            result = result + t.getName() + ";";
        }
        ArrayList<String> splitList = splitOnSpace(result);
        return splitList;
    }


    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(";");
        return new ArrayList<>(Arrays.asList(splits));
    }


    // MODIFIES: this
    // EFFECTS: sorts watchlistinput model by alphabet
    //          if they have same alphabet the one added last goes on top
    public void sortWatchlistAlphabetically() {
        //
    }


    public void save(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        for (String s : this.printTitlesWithSpace()) {
            if (!(lines.contains(s))) {
                lines.add(s);
            }
        }
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }

    public void load(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase, String filename) throws IOException, AlreadyInWatchlistException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            this.addTitle(movieDatabase.searchfortitlebyname(line));
            this.addTitle(tvShowDatabase.searchfortitlebyname(line));
            this.addTitle(tvShowDatabase.searchforTVEpisodeByName(line));
        }
    }


    public void namingWatchlist() {
        Scanner scanner = new Scanner(System.in);
        String watchlistname = "";
        System.out.println("What would you like to name your watchlist");
        watchlistname = scanner.nextLine();
        this.setName(watchlistname);
    }



    private void addTitlesToWatchlistLoopForMovies(MovieDatabase movieDatabase) {
        //    addTitlesToWatchlistLoopGeneral(movieDatabase);
        String moviename = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Which movie would you like to add");
            moviename = scanner.nextLine();
            for (VisualEntertainment m : movieDatabase.getTitles()) {
                if (moviename.equals(m.getName())) {
                    System.out.println("Found the movie!");
                    m.displaydetails();
                    AddAndRemoveTitles(m);
                }
            }

            if (moviename.equals("quit")) {
                break;
            }
        }

    }

    private void addingTitlesToWatchlistLoopForTVShows(TVShowDatabase tvShowDatabase) {

        //     addTitlesToWatchlistLoopGeneral(tvShowDatabase);
        String tvname = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Which show would you like to add");
            tvname = scanner.nextLine();
            for (VisualEntertainment ts : tvShowDatabase.getTitles()) {
                if (tvname.equals(ts.getName())) {
                    System.out.println("Found the show!");
                    ts.displaydetails();
                    String answerchoice = "";
                    System.out.println("Would you like to look into particular episodes?");
                    String answerchoice3 = "";
                    answerchoice3 = scanner.nextLine();
                    if (answerchoice3.equals("yes")) {
                        AddAndRemoveEpisodes(ts);
                    } else {
                        AddAndRemoveTitles(ts);
                    }
                }
            }

            if (tvname.equals("quit")) {
                break;
            }
        }
    }

    private void AddAndRemoveEpisodes(VisualEntertainment ts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter season");
        String num = "";
        num = scanner.nextLine();
        if (ts.getEpisodes().containsKey(num)) {
            List<Episode> eps = ts.getEpisodes().get(num);
            String answerchoice4 = "";
            System.out.println("Enter episode name");
            answerchoice4 = scanner.nextLine();
            for (Episode e : eps) {
                if (answerchoice4.equals(e.name)) {
                    System.out.println("Found the episode!");
                    e.displaydetails();
                    AddRemoveAndProgressOfEpisodes(ts, e);
                }
            }
        }
    }

    private void AddRemoveAndProgressOfEpisodes(VisualEntertainment ts, Episode e) {
        Scanner scanner = new Scanner(System.in);
        String answerchoice2 = "";
        System.out.println("Would you like to add this [1] episode or [2] remove the episode from your watchlist?");
        answerchoice2 = scanner.nextLine();
        if (answerchoice2.equals("1")) {
            try {
                this.addTitle(e);
            } catch (AlreadyInWatchlistException alreadyInWatchlistException) {
                System.out.println("Already in watchlist");
            }
            String choice2 = "";
            System.out.println("Would you like to know far you are in this show?");
            choice2 = scanner.nextLine();
            if (choice2.equals("yes")) {
                System.out.println(ts.howFarAlong(this) + "%");
            }
        } else if (answerchoice2.equals("2")) {
            try {
                this.removeTitle(e);
            } catch (NotInTheWatchlistException notInTheWatchlistException) {
                System.out.println("Not in the watchlist");
            }
        }
    }

    private void AddAndRemoveTitles(VisualEntertainment v) {
        Scanner scanner = new Scanner(System.in);
        String answerchoice;
        System.out.println("Would you like to [1] add or [2] remove this tv show to your watchlist?");
        answerchoice = scanner.nextLine();
        if (answerchoice.equals("1")) {
            try {
                this.addTitle(v);
            } catch (AlreadyInWatchlistException alreadyInWatchlistException) {
                System.out.println("Already in Watchlist");
            }
        } else if (answerchoice.equals("2")) {
            try {
                this.removeTitle(v);
            } catch (NotInTheWatchlistException notInTheWatchlistException) {
                System.out.println("Not in the watchlist");
            } finally {
                System.out.println("That's it folks");
            }
        }
    }


    public void addingTitlesToWatchlistLoop(MovieDatabase movieDatabase, TVShowDatabase
            tvShowDatabase) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (true) {
            System.out.println("Would you like to add a movie or TV show?");
            System.out.println("[1] Movie [2] TV Show [3] quit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                addTitlesToWatchlistLoopForMovies(movieDatabase);
            } else if (choice.equals("2")) {
                addingTitlesToWatchlistLoopForTVShows(tvShowDatabase);
            } else if (choice.equals("3")) {
                break;
            }
        }
    }



}