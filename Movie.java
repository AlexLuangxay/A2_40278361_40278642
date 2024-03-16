import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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

    // Method that returns path of the file by reading the manifest and putting each
    // line in a string array
    public static String[] readManifest() {

        String[] manifest_part1 = new String[10];
        try {

            FileInputStream file = new FileInputStream("manifest.txt");
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            for (int i = 0; i < 10; i++) {
                manifest_part1[i] = line;
                System.out.println(line);
                line = sc.nextLine();
            }
            sc.close();
        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return manifest_part1;
    }

    // do_part_one_manifest method (this method will basically get each path from
    // the part 1 manifest, and analyse each file if the movies inside are correct)

    public static void do_part_one_manifest(String[] manifest_part1) {

    }

}