package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Movie extends VisualEntertainment{


    public Movie(float rating, String name, String genre) {
        super(rating, name, genre);
    }


    @Override
    public void update() {
        System.out.println("Something has been added");
    }
}
