package model;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase extends VisualEntertainmentDatabase {
    private List<VisualEntertainment> movies = new ArrayList<>();

    public MovieDatabase() {
        super.titles = movies;
    }




}

