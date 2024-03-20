import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import Exceptions.*;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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

            if (movie[3].equals("NC-17")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("movie_genre\\nc_17.csv", true));
                writer.write(movie[0] + "," + movie[1] + "," + movie[2] + "," + movie[3] + "," + movie[4] + ","
                        + movie[5] + "," + movie[6] + "," + movie[7] + "," + movie[8] + "," + movie[9]);
                writer.newLine();
                writer.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void do_part2(String [] part2manifest){
Scanner csv = null;
ObjectOutputStream outputStream = null;
PrintWriter printWriter = null;
String [] part3manifest = part2manifest;

try{

//may need to create printwriter object here instead
printWriter = new PrintWriter(new FileOutputStream("part3_manifest.txt", true));

for (int i = 0;i<part2manifest.length; i++){
int csvMovieCount = 0;  //initializing a variable that will count how many movies a given csv file contains
//for every line in part2_manifest.txt, stores the name of the csv file into a String variable and creates a Scanner that will read the csv file
csv = new Scanner(new FileInputStream(part2manifest[i]));
csv.useDelimiter(",");  //setting the delimiter of the csv file scanner as a comma, intead of a blank space to read the contents of the csv file(s)

while(csv.hasNextLine()){      //counting how many movies a given csv file contains
csvMovieCount++;
csv.nextLine();
}

Movie [] movies = new Movie[csvMovieCount];   //creating an array of movies for a particular genre, with the correct size

for (int m = 0; m<movies.length && (csv.hasNextLine()); m++){

int year = csv.nextInt();
String title = csv.next();
int length = csv.nextInt();
String genre = csv.next();
String rating = csv.next();
double score = csv.nextDouble();        //placing every movie the csv file contains into an array of Movie objects
String director = csv.next();
String actor1 = csv.next();
String actor2 = csv.next();
String actor3 = csv.next();

movies [m] = new Movie(year, title, length, genre, rating, score, director, actor1, actor2, actor3);

}

part3manifest [i] = part2manifest [i].replaceAll("csv", "ser");  //replacing the file extension of the csv file with .ser

outputStream = new ObjectOutputStream( new FileOutputStream(part3manifest[i]));  //creating the objectoutputstream that will be used for converting the csv file into a .ser file

                                             //write to binary file here
                                              //append binary file to part3_manifest.txt
for (int n = 0; n<movies.length; n++){
outputStream.writeObject(movies[n]);  //writing to the .ser file
}


//appending the name of the binary file to the part3_manifest.txt file
printWriter.println(part3manifest[i]);


} //end of very first while loop
csv.close();
printWriter.close();
}

catch(FileNotFoundException e){                            //catching potential exceptions that might arise from creating those two objects
System.out.println("a file was not found");
}
catch(IOException e){

System.out.println("A reading error occured");
}


}
}
