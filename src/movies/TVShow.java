package movies;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class TVShow extends VisualEntertainment {
    private Map<String, List<Episode>> episodes;

    public TVShow(float rating, String name, String genre) {
        super(rating, name, genre);
        this.episodes = new HashMap<String, List<Episode>>();
    }

    @Override
    public Map<String, List<Episode>> getEpisodes(){
        return this.episodes;
    }

    public void setEpisodes(String season, ArrayList<Episode> episodes) {
            this.episodes.put(season, episodes);
        }


        @Override
    public float howFarAlong(Watchlist watchlist) {
        float numofeps = 0;
        float size = 0;
        for (VisualEntertainment ve: watchlist.getTitles()) {
            for (List<Episode> loe: episodes.values()) {
                if (loe.contains(ve)) {
                    numofeps++;
                }

            }
        }
        for (List<Episode> le: episodes.values()) {
            for (Episode e: le) {
                size++;
            }
        }

        return ((numofeps)/(size) * 100);
    }


    @Override
    protected void displaydetails() {
        System.out.println("Name: " + super.name);
        System.out.println("Genre: " + super.genre);
        System.out.println("Rating: " + super.rating);
        System.out.println("Episodes:" + episodes.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVShow tvShow = (TVShow) o;
        return Objects.equals(episodes, tvShow.episodes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(episodes);
    }
}
