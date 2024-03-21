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

}
