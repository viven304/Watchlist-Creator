package movies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TVShow extends VisualEntertainment {
    private ArrayList<Episode> episodes;

    public TVShow(float rating, String name, String genre) {
        super(rating, name, genre);
        this.episodes = new ArrayList<>();
    }

    public ArrayList<Episode> getEpisodes(){
        return this.episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }


    @Override
    protected void displaydetails() {
        System.out.println("Name: " + super.name);
        System.out.println("Genre: " + super.genre);
        System.out.println("Rating: " + super.rating);
        System.out.println("Episodes:" + episodes.size());
    }



}
