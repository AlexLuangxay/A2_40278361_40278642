import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import Exceptions.*;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Movie implements Serializable {
    // Attributes
    int year;
    String title;
    int duration;
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
    public Movie(int year, String title, int duration, String genre, String rating, double score, String director,
            String actor1, String actor2, String actor3) {

        this.year = year;
        this.title = title;
        this.duration = duration;
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
    public static String[] readManifest(String path) {
        String[] anymanifest = new String[10];
        try {
            FileInputStream file = new FileInputStream(path);
            Scanner sc = new Scanner(file);
            int count = 0;
            while (sc.hasNextLine() && count < 10) {
                String line = sc.nextLine();
                anymanifest[count] = line;
                count++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return anymanifest;
    }

    // do_part_one_manifest method (this method will basically get each path from
    // the part 1 manifest, and analyse each file if the movies inside are correct)

    public static void do_part_one_manifest(String[] manifest_part1) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("manifests_txt_files\\part2_manifest.txt"));
            writer.write("musical.csv\n" + //
                    "comedy.csv\n" + //
                    "animation.csv\n" + //
                    "adventure.csv\n" + //
                    "drama.csv\n" + //
                    "crime.csv\n" + //
                    "biography.csv\n" + //
                    "horror.csv\n" + //
                    "action.csv\n" + //
                    "documentary.csv\n" + //
                    "fantasy.csv\n" + //
                    "mystery.csv\n" + //
                    "sci-fi.csv\n" + //
                    "family.csv\n" + //
                    "western.csv\n" + //
                    "romance.csv\n" + //
                    "thriller.csv");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < 10; i++) {
            try {
                FileInputStream file = new FileInputStream("Input files\\" + manifest_part1[i]);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {

                    String line = sc.nextLine();
                    String[] movie = line.split(",");

                    // CHECKING SEMENTIC ERRORS
                    try {

                        int year = Integer.parseInt(movie[0]);
                        String title = movie[1];
                        int duration = Integer.parseInt(movie[2]);
                        String genre = movie[3];
                        String rating = movie[4];
                        double score = Double.parseDouble(movie[5]);
                        String actor1 = movie[7];
                        String actor2 = movie[8];
                        String actor3 = movie[9];

                        // CHECKING SYNTAX ERRORS
                        if (movie.length < 10) { // MissingFieldsException
                            throw new MissingFieldsException(
                                    "The file " + manifest_part1[i] + " is missing a field");
                        }

                        if (movie.length > 10) {// ExcessFieldsException
                            throw new ExcessFieldsException(
                                    "The file " + manifest_part1[i] + " has an excess of fields");
                        }

                        if (year < 1900 || year > 2000) {// BadYearException
                            throw new BadYearException("The year is not valid");
                        }

                        if (duration < 0 || duration > 300) {// BadDurationException
                            throw new BadDurationException("The duration is not valid");
                        }

                        if (score < 0 || score > 10) {// BadScoreException
                            throw new BadScoreException("The score is not valid");
                        }

                        if (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG-13")
                                && !rating.equals("R")
                                && !rating.equals("NC-17")) {// BadRatingException
                            throw new BadRatingException("The rating is not valid");
                        }

                        if (!genre.equals("Action") && !genre.equals("Adventure") && !genre.equals("Comedy")
                                && !genre.equals("Drama") && !genre.equals("Horror") && !genre.equals("Musical")
                                && !genre.equals("Sci-Fi") && !genre.equals("Mystery")
                                && !genre.equals("Western") && !genre.equals("Animation") && !genre.equals("Biography")
                                && !genre.equals("Crime") && !genre.equals("Documentary")
                                && !genre.equals("Thriller") && !genre.equals("Family")
                                && !genre.equals("Romance") && !genre.equals("Fantasy")) {// BadGenreException
                            throw new BadGenreException("The genre is not valid");
                        }

                        // Number of quotes need to be even in the title
                        int number_of_quotes = 0;
                        for (int k = 0; k < title.length(); k++) { // loop that goes through each character of
                                                                   // the
                                                                   // string, to search a quote

                            if (title.charAt(k) == '"') { // if the character is a quote, increment the number of
                                                          // quotes
                                number_of_quotes++;
                            }

                        }
                        if (number_of_quotes % 2 != 0) { // if the number of quotes is odd, throw an exception
                            throw new MissingQuotesException(
                                    "The file " + manifest_part1[i] + " is missing a quote");
                        }

                        if (actor1.equals("") || actor2.equals("") || actor3.equals("")) {
                            throw new BadNameException("The file " + manifest_part1[i] + " is missing an actor(s)");
                        }

                        if (title.equals("")) {
                            throw new BadTitleException("The file " + manifest_part1[i] + " is missing a title");
                        }

                        else {
                            Movie.sortMovie(movie);
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        BufferedWriter writer = new BufferedWriter(new FileWriter("bad_movie_records.txt", true));
                        writer.write(line);
                        writer.newLine();
                        writer.close();
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    // Method that sorts the movies by genre
    public static void sortMovie(String[] movie) {
        try {
            if (movie[3].equals("Action")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\action.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Adventure")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\adventure.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Comedy")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\comedy.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Drama")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\drama.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Horror")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\horror.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }
            if (movie[3].equals("Musical")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\musical.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }
            if (movie[3].equals("Sci-Fi")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\sci_fi.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Animation")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\animation.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Crime")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\crime.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Fantasy")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\fantasy.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Mystery")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\mystery.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Romance")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\romance.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Thriller")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\thriller.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Western")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\western.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Family")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\family.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Biography")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\biography.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

            if (movie[3].equals("Documentary")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\documentary.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void do_part2(String[] manifest2) {

        try { // Create the manifest 3
            BufferedWriter writer = new BufferedWriter(new FileWriter("manifests_txt_files\\part3_manifest.txt"));
            writer.write("musical.ser\n" + //
                    "comedy.ser\n" + //
                    "animation.ser\n" + //
                    "adventure.ser\n" + //
                    "drama.ser\n" + //
                    "crime.ser\n" + //
                    "biography.ser\n" + //
                    "horror.ser\n" + //
                    "action.ser\n" + //
                    "documentary.ser\n" + //
                    "fantasy.ser\n" + //
                    "mystery.ser\n" + //
                    "sci-fi.ser\n" + //
                    "family.ser\n" + //
                    "western.ser\n" + //
                    "romance.ser\n" + //
                    "thriller.ser");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < manifest2.length; i++) { // Loop that goes through the manifestPart2 array, and read its
                                                     // content of a specifique index, hence a specifique genre file

            try {

                // Opening the file, and counting how many movies are in this file, by counting
                // the number of lines
                FileInputStream file = new FileInputStream("movie_genre\\" + manifest2[i]);
                Scanner sc = new Scanner(file);

                int movieCounter = 0;
                while (sc.hasNextLine()) {
                    movieCounter++;
                    sc.nextLine();
                }

                Movie[] arr = new Movie[movieCounter]; // Creating an array with a length of the number of movies
                                                       // counted

                sc.close();

                // Reread the file from the begining, and store each line as a movie object
                FileInputStream file2 = new FileInputStream("movie_genre\\" + manifest2[i]);
                Scanner sc2 = new Scanner(file2);
                for (int j = 0; j < movieCounter; j++) {

                    String line = sc2.nextLine();
                    String[] movie = line.split(",");

                    int year = Integer.parseInt(movie[0]);
                    String title = movie[1];
                    int length = Integer.parseInt(movie[2]);
                    String genre = movie[3];
                    String rating = movie[4];
                    double score = Double.parseDouble(movie[5]);
                    String director = movie[6];
                    String actor1 = movie[7];
                    String actor2 = movie[8];
                    String actor3 = movie[9];

                    Movie m = new Movie(year, title, length, genre, rating, score, director, actor1, actor2, actor3);
                    arr[j] = m;

                }
                sc.close();

                // Create a file with the same name as the genre file, but with the .ser
                // extension

                String[] manifest_part3 = Movie.readManifest("manifests_txt_files\\part3_manifest.txt");

                FileOutputStream fileOut = new FileOutputStream("movie_genre_ser\\" + manifest_part3[i]);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                // Write the array of movies to the file
                for (int x = 0; x < arr.length; x++) {
                    out.writeObject(arr[x]);
                }

                ObjectInputStream example = new ObjectInputStream(new FileInputStream("movie_genre_ser\\adventure.ser"));
                for (int x = 0; x < 39; x++) {
                    System.out.println(example.readObject());
                }
                out.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    // movie toString method
    public String toString() {
        return "Year: " + year + " Title: " + title + " Duration: " + duration + " Genre: " + genre + " Rating: "
                + rating
                + " Score: " + score + " Director: " + director + " Actor1: " + actor1 + " Actor2: " + actor2
                + " Actor3: "
                + actor3;
    }

}
