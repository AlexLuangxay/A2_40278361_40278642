import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) {

        String[] manifest_part1 = Movie.readManifest("manifests_txt_files\\part1_manifest.txt");

        Movie.do_part_one_manifest(manifest_part1);

        String[] manifest_part2 = Movie.readManifest("manifests_txt_files\\part2_manifest.txt");

        // Creating the files for the genres that was not created
        for (int i = 0; i < manifest_part2.length; i++) {
            String path = "movie_genre\\" + manifest_part2[i];
            File file = new File(path);

            if (!file.exists()) {
                try {
                    // If the file doesn't exist, create it
                    PrintWriter writer = new PrintWriter(path);
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        Movie.do_part2(manifest_part2);

        String[] manifest_part3 = Movie.readManifest("manifests_txt_files\\part3_manifest.txt");
        Movie.do_part3(manifest_part3);


    }

    public static void mainMenu() {
        System.out.println("-----------------------------");
        System.out.println("Main Menu");
        System.out.println("----------------------------");
        System.out.println("s Select a movie array to navigate");
        System.out.println("n Navigate musical movies (0 records)");
        System.out.println("x Exit");
        System.out.println("-----------------------------");
    }

    public static void navigate() {
        System.out.println("------------------------------");
        System.out.println("Genre Sub-Menu");
        System.out.println("------------------------------");
        System.out.println("1 musical (0 movies)");
        System.out.println("2 comedy (73 movies)");
        System.out.println("3 animation (2 movies)");
        System.out.println("4 adventure (28 movies)");
        System.out.println("5 drama (43 movies)");
        System.out.println("6 crime (11 movies)");
        System.out.println("7 biography (10 movies)");
        System.out.println("8 horror (11 movies)");
        System.out.println("9 action (71 movies)");
        System.out.println("10 documentary (7 movies)");
        System.out.println("11 fantasy (3 movies)");
        System.out.println("12 mystery (3 movies)");
        System.out.println("13 sci-fi (0 movies)");
        System.out.println("14 family (0 movies)");
        System.out.println("15 western (0 movies)");
        System.out.println("16 romance (1 movies)");
        System.out.println("17 thriller (0 movies)");
        System.out.println("18 Exit");
        System.out.println("------------------------------");
    }

    

}
