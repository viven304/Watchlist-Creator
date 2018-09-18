package ui;

import movies.Movie;
import movies.Genre;

import java.util.Scanner;


public class Main {
    Scanner scanner = new Scanner(System.in);
    Movie conjuring = new Movie(86, "Conjuring", "Genre");
    Genre horror = new Genre();
    Movie interstellar = new Movie(71, "Interstellar", "Sci-Fi");
    Genre scifi = new Genre();

    public Main() {

        String moviegenre = "";
        horror.setGenreName("Horror");
        horror.addMovie(conjuring);
        scifi.setGenreName("Sci-Fi");
        scifi.addMovie(interstellar);
        while (true) {
            System.out.println("Enter movie genre");
            moviegenre = scanner.nextLine();
            if (moviegenre.equals("Horror")) {
                String moviename = "";
                while (true) {
                    System.out.println("Enter movie name");
                    moviename = scanner.nextLine();
                    for (Movie m : horror.GenreMovies) {
                        if (moviename.equals(m.name)) {
                            System.out.println("Found the movie!");
                            System.out.println("The movie is called " + m.name + " and has a rating of " + m.rating);
                        }
                    }
                }
            } else if (moviegenre.equals("Sci-Fi")) {
                String moviename = "";
                while (true) {
                    System.out.println("Enter movie name");
                    moviename = scanner.nextLine();
                    for (Movie m : scifi.GenreMovies) {
                        if (moviename.equals(m.name)) {
                            System.out.println("Found the movie!");
                            System.out.println("The movie is called " + m.name + " and has a rating of " + m.rating);
                        }

                        
                    }
                }
            } else if (moviegenre.equals("quit")) {
                break;
            }
            System.out.println("thank you for using the Movie Database");
        }
}






    public static void main(String[] args) {
    new Main();
    }
}




