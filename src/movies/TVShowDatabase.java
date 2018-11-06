package movies;


import java.util.ArrayList;
import java.util.List;

public class TVShowDatabase extends VisualEntertainmentDatabase {
    private List<VisualEntertainment> shows = new ArrayList<>();

    public TVShowDatabase() {
        super.titles = shows;
    }

    public void addTVShow(VisualEntertainment m) {
        shows.add(m);
    }


    @Override
    public VisualEntertainment searchfortitlebyname(String name) {
        VisualEntertainment result = new TVShow(0, "", "");
        for (VisualEntertainment ts : shows) {
            if (ts.getName().equals(name)) {
                result = ts;
            }
        }
        return result;
    }

    public Episode searchforTVEpisodeByName(String name) {
        Episode result = new Episode(0, "", "");
        for (VisualEntertainment tvs: shows) {
            for (List<Episode> loe: tvs.getEpisodes().values()) {
                for (Episode e: loe) {
                    if (e.name.equals(name)) {
                        result = e;
                    }
                }
            }
        }
        return result;
    }


}
