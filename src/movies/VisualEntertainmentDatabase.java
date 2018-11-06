package movies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class VisualEntertainmentDatabase {

    protected List<VisualEntertainment> titles;

    public VisualEntertainmentDatabase() {
        titles = new ArrayList<>();

    }
    protected abstract VisualEntertainment searchfortitlebyname(String name);


    public List<VisualEntertainment> getTitles() {
        return titles;
    }

}
