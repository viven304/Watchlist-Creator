package movies;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase extends VisualEntertainmentDatabase {
    private List<VisualEntertainment> movies = new ArrayList<>();

    public MovieDatabase() {
        super.titles = movies;
    }

    public void addMovie(Movie m) {
        this.movies.add(m);
    }


    @Override
    public VisualEntertainment searchfortitlebyname(String name) {
        VisualEntertainment result = new Movie(0, "", "");
        for (VisualEntertainment m: movies) {
            if (m.getName().equals(name)) {
                result = m;
            }
        }
        return result;
    }

}

