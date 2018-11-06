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
    protected void displaydetails() {
        System.out.println("Name: " + super.name);
        System.out.println("Genre: " + super.genre);
        System.out.println("Rating: " + super.rating);
    }

}
