package movies;


import java.util.ArrayList;
import java.util.List;

public class TVShowDatabase {
    private List<TVShow> shows = new ArrayList<>();

    public void addTVShow(TVShow m) {
        this.shows.add(m);
    }

    public List<TVShow> getShows() {
        return shows;
    }

    public TVShow searchforTVShowbyname(String name) {
        TVShow result = new TVShow(0, "", "");
        for (TVShow ts : shows) {
            if (ts.getName().equals(name)) {
                result = ts;
            }
        }
        return result;
    }

//    public Episode searchforTVEpisodeByName(String name) {
//        Episode result = new Episode(0, "", "");
//        for (TVShow tvs: shows) {
//            if (tvs.getEpisodes().containsKey(name)) {
//                result = tvs.getEpisodes().get(name);
//            }
//        }
//        return result;
//    }


}
