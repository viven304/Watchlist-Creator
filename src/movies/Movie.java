package movies;

import java.time.LocalDate;
import java.util.ArrayList;


public class Movie extends VisualEntertainment{
    private float rating;
    private String name;
    private String genre;
    private ArrayList<String> watchlists;
    private LocalDate datewatched;

    public Movie(float rating, String name, String genre) {
        super(rating, name, genre);
    }


@Override
protected void displaydetails() {
    System.out.println("Name: " + super.name);
    System.out.println("Genre: " + super.genre);
    System.out.println("Rating: " + super.rating);
    }

}
