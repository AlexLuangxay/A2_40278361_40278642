import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import Exceptions.*;

public class Movie {
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
    public static String[] readManifest() {
        String[] manifest_part1 = new String[10];
        try {
            FileInputStream file = new FileInputStream("manifests_txt_files\\part1_manifest.txt");
            Scanner sc = new Scanner(file);
            int count = 0;
            while (sc.hasNextLine() && count < 10) {
                String line = sc.nextLine();
                manifest_part1[count] = line;
                System.out.println(line);
                count++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return manifest_part1;
    }

    // do_part_one_manifest method (this method will basically get each path from
    // the part 1 manifest, and analyse each file if the movies inside are correct)

    public static void do_part_one_manifest(String[] manifest_part1) {

        for (int i = 0; i < 10; i++) {
            try {
                FileInputStream file = new FileInputStream(manifest_part1[i]);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {

                    String line = sc.nextLine();
                    String[] movie = line.split(",");
                    int year = Integer.parseInt(movie[0]);
                    String title = movie[1];
                    int duration = Integer.parseInt(movie[2]);
                    String genre = movie[3];
                    String rating = movie[4];
                    double score = Double.parseDouble(movie[5]);
                    String director = movie[6];
                    String actor1 = movie[7];
                    String actor2 = movie[8];
                    String actor3 = movie[9];

                    // CHECKING SEMENTIC ERRORS
                    try {
                        if (year < 1900 || year > 2000) {// BadYearException
                            throw new BadYearException("The year is not valid");
                        }

                        if (duration < 0 || duration > 300) {// BadDurationException
                            throw new BadDurationException("The length is not valid");
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
                                && !genre.equals("Science Fiction") && !genre.equals("War")
                                && !genre.equals("Western")) {// BadGenreException
                            throw new BadGenreException("The genre is not valid");
                        }

                        // CHECKING SYNTAX ERRORS
                        if (movie.length < 9) { // EccessFieldsException
                            throw new MissingFieldsException(
                                    "The file " + manifest_part1[i] + " is missing a field");
                        }

                        if (movie.length > 9) {// MissingFieldsException
                            throw new ExcessFieldsException(
                                    "The file " + manifest_part1[i] + " has an excess of fields");
                        }

                        // Number of quotes need to be even
                        for (int j = 0; j < movie.length; j++) { // loop that goes through each string of the array
                            for (int k = 0; k < movie[j].length(); k++) { // loop that goes through each character of
                                                                          // the
                                                                          // string, to search a quote
                                int number_of_quotes = 0;
                                if (movie[j].charAt(k) == '"') { // if the character is a quote, increment the number of
                                                                 // quotes
                                    number_of_quotes++;
                                }
                                if (number_of_quotes % 2 != 0) { // if the number of quotes is odd, throw an exception
                                    throw new MissingQuotesException(
                                            "The file " + manifest_part1[i] + " is missing a quote");
                                }
                            }
                        }
                        if (movie[7].equals("") || movie[8].equals("") || movie[9].equals("")) {
                            throw new BadNameException("The file " + manifest_part1[i] + " is missing an actor(s)");
                        }

                        if (movie[1].equals("")) {
                            throw new BadTitleException("The file " + manifest_part1[i] + " is missing a title");
                        }
                    }catch (BadDurationException e) {
                        System.out.println(e.getMessage());
                    } catch (BadGenreException e) {
                        System.out.println(e.getMessage());
                    } catch (BadNameException e) {
                        System.out.println(e.getMessage());
                    } catch (BadRatingException e) {
                        System.out.println(e.getMessage());
                    } catch (BadScoreException e) {
                        System.out.println(e.getMessage());
                    } catch (BadTitleException e) {
                        System.out.println(e.getMessage());
                    } catch (ExcessFieldsException e) {
                        System.out.println(e.getMessage());
                    } catch (MissingFieldsException e) {
                        System.out.println(e.getMessage());
                    } catch (MissingQuotesException e) {
                        System.out.println(e.getMessage());
                    } catch (BadYearException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }
}
