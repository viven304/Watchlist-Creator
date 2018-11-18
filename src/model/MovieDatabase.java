package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MovieDatabase extends VisualEntertainmentDatabase {
    private List<VisualEntertainment> movies = new ArrayList<>();
    private String name;

    public MovieDatabase() {
        super.titles = movies;
        super.name = "MovieDatabase";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("lol");
    }
}

