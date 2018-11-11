package model;

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
    public void update(String name) {
        System.out.println(name + " has been added!");
    }
}
