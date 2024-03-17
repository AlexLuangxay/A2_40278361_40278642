public class Driver {
    public static void main(String[] args) {

        String[] manifest_part1 = Movie.readManifest();

        Movie.do_part_one_manifest(manifest_part1);
    }

}
