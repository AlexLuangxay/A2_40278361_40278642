import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Movie {
    // Attributes
    int year;
    String title;
    int length;
    String genre;
    String rating;
    double score;
    String director;
    String actor1;
    String actor2;
    String actor3;
    // Constructor

    // default constructor
    public Movie() {
    }

    // parameterized constructor
    public Movie(int year, String title, int length, String genre, String rating, double score, String director,
            String actor1, String actor2, String actor3) {

        this.year = year;
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
        this.score = score;
        this.director = director;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
    }
    

}