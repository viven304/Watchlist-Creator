package movies;

import java.util.ArrayList;

public class Movie {
    public float rating;
    public String name;
    public String genre;

    public Movie(int rating, String name, String genre) {
        this.rating = rating;
        this.name = name;
        this.genre = genre;
    }

public void print() {
    System.out.println(name + " has a rating of " + rating);
}

}
