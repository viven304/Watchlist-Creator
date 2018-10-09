package movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Watchlist implements Load, Save {
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


    // EFFECTS: gets watchlistinput's movies
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
    public void addTitle(VisualEntertainment title) {
        if (!(title.getName().equals(""))) {
            if (!(this.list.contains(title))) {
                this.list.add(title);
                this.lastmodified = LocalDate.now();
            }
        }
    }


    // REQUIRES: a movie that is already in the watchlistinput
    // MODIFIES: this and movie
    // EFFECTS: it removes the movie from the watchlistinput
    //          and removes the watchlistinput from the movie
    //          updates last modified to current date
    public void removeTitle(VisualEntertainment title) {
        if (this.list.contains(title)) {
            this.list.remove(title);
            this.lastmodified = LocalDate.now();
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
    // EFFECTS: sorts watchlistinput movies by alphabet
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

    public void load(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase, String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            this.addTitle(movieDatabase.searchformoviebyname(line));
            this.addTitle(tvShowDatabase.searchforTVShowbyname(line));
            this.addTitle(tvShowDatabase.searchforTVEpisodeByName(line));
        }
    }


    public void wouldYouLikeToKnowHowFar() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println("Would you like to know how far along are you?");
        choice = scanner.nextLine();
        if (choice.equals("yes")) {

        }
    }

    public void namingWatchlist() {
        Scanner scanner = new Scanner(System.in);
        String watchlistname = "";
        System.out.println("What would you like to name your watchlist");
        watchlistname = scanner.nextLine();
        this.setName(watchlistname);
    }


    public void addingTitlesToWatchlistLoop(MovieDatabase movieDatabase, TVShowDatabase tvShowDatabase) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (true) {
            System.out.println("Would you like to add a movie or TV show?");
            System.out.println("[1] Movie [2] TV Show [3] quit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                String moviename = "";

                while (true) {
                    System.out.println("Which movie would you like to add");
                    moviename = scanner.nextLine();
                    for (VisualEntertainment m : movieDatabase.getMovies()) {
                        if (moviename.equals(m.getName())) {
                            System.out.println("Found the movie!");
                            m.displaydetails();
                            String answerchoice = "";
                            System.out.println("Would you like to add this movie to your watchlist?");
                            answerchoice = scanner.nextLine();
                            if (answerchoice.equals("yes")) {
                                if (this.getTitles().contains(m)) {
                                    System.out.println("Sorry, this is already in the watchlist");
                                } else {
                                    this.addTitle(m);
                                    System.out.println("Successful!");
                                }
                            }
                        }
                    }

                    if (moviename.equals("quit")) {
                        break;
                    }
                }
            } else if (choice.equals("2")) {
                String tvname = "";
                while (true) {
                    System.out.println("Which show would you like to add");
                    tvname = scanner.nextLine();
                    for (TVShow ts : tvShowDatabase.getShows()) {
                        if (tvname.equals(ts.getName())) {
                            System.out.println("Found the show!");
                            ts.displaydetails();
                            String answerchoice = "";
                            System.out.println("Would you like to add this show to your watchlist?");
                            answerchoice = scanner.nextLine();
                            if (answerchoice.equals("yes")) {
                                if (this.getTitles().contains(ts)) {
                                    System.out.println("Sorry, this is already in the watchlist");
                                } else {
                                    this.addTitle(ts);
                                    System.out.println("Successful!");
                                }
                            }
                        }
                        for (Episode ep : ts.getEpisodes()) {
                            if (tvname.equals(ep.name)) {
                                System.out.println("Found the show!");
                                ep.displaydetails();
                                String answerchoice = "";
                                System.out.println("Would you like to add this [1] episode or [2] the tv show to your watchlist?");
                                answerchoice = scanner.nextLine();
                                if (answerchoice.equals("1")) {
                                    if (this.getTitles().contains(ep)) {
                                        System.out.println("Sorry, this is already in the watchlist");

                                    } else {
                                        this.addTitle(ep);
                                        System.out.println("Successful!");
                                    }
                                } else if (answerchoice.equals("2")) {
                                    if (this.getTitles().contains(ts)) {
                                        System.out.println("Sorry, this is already in the watchlist");
                                    } else {
                                        this.addTitle(ts);
                                        System.out.println("Successful!");
                                    }
                                }
                            }
                        }
                    }

                    if (tvname.equals("quit")) {
                        break;
                    }
                }
            } else if (choice.equals("3")) {
                break;
            }
        }
        }
    }


