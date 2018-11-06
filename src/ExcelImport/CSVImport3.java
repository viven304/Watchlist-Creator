package ExcelImport;

import model.Movie;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


public class CSVImport3 {
    public static void main(String[] args) {
        List<Movie> movies = readMoviesFromCSV("C:\\Users\\viven\\Documents\\movie_metadata.csv");

        for (Movie m: movies) {
            System.out.println(m);
        }
    }

    private static List<Movie> readMoviesFromCSV(String fileName) {
        List<Movie> movies = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br= Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Movie movie = createMovie(attributes);

                movies.add(movie);

                line = br.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return movies;
        }

private static Movie createMovie(String[] metadata) {
        String name = metadata[0];
        float rating = Float.parseFloat(metadata[1]);
        String genre = metadata[2];

        return new Movie(rating, name, genre);
    }
}
