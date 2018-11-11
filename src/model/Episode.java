package model;

public class Episode extends VisualEntertainment {
    private TVShow tvShow;

    public Episode(float rating, String name, String genre) {
        super(rating, name, genre);
    }

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
    }

    @Override
    public void update(String name) {
        System.out.println(name + " has been added!");
    }

}
