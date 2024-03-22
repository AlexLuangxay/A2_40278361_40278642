import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

   static String choiceN = "n Navigate musical movies (0 records)";
   static int comedyIndex = 0;
    static int animationIndex = 0;
    static int adventureIndex = 0;
    static int dramaIndex = 0;
    static int crimeIndex = 0;
    static int biographyIndex = 0;
    static int horrorIndex = 0;
    static int actionIndex = 0;
    static int documentaryIndex = 0;
    static int fantasyIndex = 0;
    static int mysteryIndex = 0;
    static int romanceIndex = 0;


    static Movie [] [] allMovies = null;
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
        //Movie.do_part3(manifest_part3);

        allMovies = Movie.do_part3(manifest_part3);

        System.out.println(allMovies[0][0]);
       // mainMenu();


    }

    public static void mainMenu() {
        System.out.println("-----------------------------");
        System.out.println("Main Menu");
        System.out.println("----------------------------");
        System.out.println("s Select a movie array to navigate");
        System.out.println(choiceN);
        System.out.println("x Exit");
        System.out.println("-----------------------------");

        Scanner in = new Scanner (System.in);
        String choice = in.nextLine();
        in.close();
        if (choice.equals("s")) {
            navigationMenu();
        } else if (choice.equals("n")) {
            
            navigateGenre();
        } else if (choice.equals("x") || choice.equals("X")) {
            System.exit(0);
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void navigationMenu() {              //choice s
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

        Scanner in = new Scanner (System.in);
        String choice = in.nextLine();
        in.close();
        switch (choice){
            case "1":

            choiceN = "n Navigate musical movies (0 records)";
            mainMenu();
            break;

            case "2":
            choiceN = "n Navigate comedy movies (73 records)";
            mainMenu();
            break;

            case "3":
            choiceN = "n Navigate animation movies (2 records)";
            mainMenu();
            break;

            case "4":
            choiceN = "n Navigate adventure movies (28 records)";
            mainMenu();
            break;

            case "5":
            choiceN = "n Navigate drama movies (43 records)";
            mainMenu();
            break;

            case "6":
            choiceN = "n Navigate crime movies (11 records)";
            mainMenu();
            break;

            case "7":
            choiceN = "n Navigate biography movies (10 records)";
            mainMenu();
            break;

            case "8":
            choiceN = "n Navigate horror movies (11 records)";
            mainMenu();
            break;

            case "9":
            choiceN = "n Navigate action movies (71 records)";
            mainMenu();
            break;

            case "10":
            choiceN = "n Navigate documentary movies (7 records)";
            mainMenu();
            break;

            case "11":
            choiceN = "n Navigate fantasy movies (3 records)";
            mainMenu();
            break;

            case "12":
            choiceN = "n Navigate mystery movies (3 records)";
            mainMenu();
            break;

            case "13":
            choiceN = "n Navigate sci-fi movies (0 records)";
            mainMenu();
            break;

            case "14":
            choiceN = "n Navigate family movies (0 records)";
            mainMenu();
            break;

            case "15":
            choiceN = "n Navigate western movies (0 records)";
            mainMenu();
            break;

            case "16":
            choiceN = "n Navigate romance movies (1 records)";
            mainMenu();
            break;

            case "17":
            choiceN = "n Navigate thriller movies (0 records)";
            mainMenu();
            break;

            case "18":
            mainMenu();
            break;

            default:
            System.out.println("Invalid choice");
            break;

        }
    }

    public static void navigateGenre(){         //choice n

        switch (choiceN){
            case "n Navigate musical movies (0 records)":
            System.out.println("No records found");
            mainMenu();
            break;

            case "n Navigate comedy movies (73 records)":
                System.out.println("Navigating comedy movies (73 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate animation movies (2 records)":
                System.out.println("Navigating animation movies (2 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate adventure movies (28 records)":
                System.out.println("Navigating adventure movies (28 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate drama movies (43 records)":
                System.out.println("Navigating drama movies (43 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate crime movies (11 records)":
                System.out.println("Navigating crime movies (11 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate biography movies (10 records)":
                System.out.println("Navigating biography movies (10 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate horror movies (11 records)":
                System.out.println("Navigating horror movies (11 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate action movies (71 records)":
                System.out.println("Navigating action movies (71 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate documentary movies (7 records)":
                System.out.println("Navigating documentary movies (7 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate fantasy movies (3 records)":
                System.out.println("Navigating fantasy movies (3 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;
            
            case "n Navigate mystery movies (3 records)":
                System.out.println("Navigating mystery movies (3 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate sci-fi movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;
            
            case "n Navigate family movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;

            case "n Navigate western movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;

            case "n Navigate romance movies (1 records)":
                System.out.println("Navigating romance movies (1 records)");
                System.out.println("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate thriller movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;
        }

        }

        public static void displayMovies(){       //after choice n
            Scanner in = new Scanner (System.in);
            int choice = in.nextInt();

            int amount = Math.abs(choice)-1;

            if (choice == 0){
                mainMenu();
            }

            if (choice>0){

                switch (choiceN){
                    case "n Navigate comedy movies (73 records)":
                    //display comedy movies
                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [0] [comedyIndex+i]);
                            comedyIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                       
                        for (int i = 0; i<allMovies[0].length-1-comedyIndex; i++){
                            System.out.println(allMovies [0] [comedyIndex+i]);
                        } comedyIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }

                    break;

                    case "n Navigate animation movies (2 records)":
                    //display animation movies
                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [1] [animationIndex+i]);
                            animationIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[1].length-1-animationIndex; i++){
                            System.out.println(allMovies [1] [animationIndex+i]);
                        }animationIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }

                    break;

                    case "n Navigate adventure movies (28 records)":
                    //display adventure movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [2] [adventureIndex+i]);
                            adventureIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[2].length-1-adventureIndex; i++){
                            System.out.println(allMovies [2] [adventureIndex+i]);
                        }adventureIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }

                    break;

                    case "n Navigate drama movies (43 records)":
                    //display drama movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [3] [dramaIndex+i]);
                            dramaIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[3].length-1-dramaIndex; i++){
                            System.out.println(allMovies [3] [dramaIndex+i]);
                        }dramaIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate crime movies (11 records)":
                    //display crime movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [4] [crimeIndex+i]);
                            crimeIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[4].length-1-crimeIndex; i++){
                            System.out.println(allMovies [4] [crimeIndex+i]);
                        }crimeIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate biography movies (10 records)":
                    //display biography movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [5] [biographyIndex+i]);
                            biographyIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[5].length-1-biographyIndex; i++){
                            System.out.println(allMovies [5] [biographyIndex+i]);
                        }biographyIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate horror movies (11 records)":
                    //display horror movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [6] [horrorIndex+i]);
                            horrorIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[6].length-1-horrorIndex; i++){
                            System.out.println(allMovies [6] [horrorIndex+i]);
                        }horrorIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate action movies (71 records)":
                    //display action movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [7] [actionIndex+i]);
                            actionIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[7].length-1-actionIndex; i++){
                            System.out.println(allMovies [7] [actionIndex+i]);
                        }actionIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate documentary movies (7 records)":
                    //display documentary movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [8] [documentaryIndex+i]);
                            documentaryIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[8].length-1-documentaryIndex; i++){
                            System.out.println(allMovies [8] [documentaryIndex+i]);
                        }documentaryIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate fantasy movies (3 records)":
                    //display fantasy movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [9] [fantasyIndex+i]);
                            fantasyIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[9].length-1-fantasyIndex; i++){
                            System.out.println(allMovies [9] [fantasyIndex+i]);
                        }
                        fantasyIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate mystery movies (3 records)":
                    //display mystery movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [10] [mysteryIndex+i]);
                            mysteryIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[10].length-1-mysteryIndex; i++){
                            System.out.println(allMovies [10] [mysteryIndex+i]);
                        }mysteryIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate romance movies (1 records)":
                    //display romance movies

                    try{
                        for (int i = 0; i<amount; i++){
                            System.out.println(allMovies [11] [romanceIndex+i]);
                            romanceIndex ++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        
                        for (int i = 0; i<allMovies[11].length-1-romanceIndex; i++){
                            System.out.println(allMovies [11] [ romanceIndex+i]);
                        }
                        romanceIndex = 0;
                    }
                    finally{
                        mainMenu();
                    }
                    break;
                }
            }

            if (choice <0){                                          //need to change the part when exception is found

                switch (choiceN){

                    case "n Navigate comedy movies (73 records)":
                    //display comedy movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [0] [comedyIndex-i]);
                            comedyIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        comedyIndex = 0;
                        for (int i = 0; i<allMovies[0].length; i++){
                            System.out.println(allMovies [0] [comedyIndex-i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate animation movies (2 records)":
                    //display animation movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [1] [animationIndex-i]);
                            animationIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        animationIndex = 0;
                        for (int i = 0; i<allMovies[1].length; i++){
                            System.out.println(allMovies [1] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate adventure movies (28 records)":
                    //display adventure movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [2] [adventureIndex-i]);
                            adventureIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        adventureIndex = 0;
                        for (int i = 0; i<allMovies[2].length; i++){
                            System.out.println(allMovies [2] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate drama movies (43 records)":
                    //display drama movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [3] [dramaIndex-i]);
                            dramaIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        dramaIndex = 0;
                        for (int i = 0; i<allMovies[3].length; i++){
                            System.out.println(allMovies [3] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate crime movies (11 records)":
                    //display crime movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [4] [crimeIndex-i]);
                            crimeIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        crimeIndex = 0;
                        for (int i = 0; i<allMovies[4].length; i++){
                            System.out.println(allMovies [4] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate biography movies (10 records)":
                    //display biography movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [5] [biographyIndex-i]);
                            biographyIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        biographyIndex = 0;
                        for (int i = 0; i<allMovies[5].length; i++){
                            System.out.println(allMovies [5] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate horror movies (11 records)":
                    //display horror movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [6] [horrorIndex-i]);
                            horrorIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        horrorIndex = 0;
                        for (int i = 0; i<allMovies[6].length; i++){
                            System.out.println(allMovies [6] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate action movies (71 records)":
                    //display action movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [7] [actionIndex-i]);
                            actionIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        actionIndex = 0;
                        for (int i = 0; i<allMovies[7].length; i++){
                            System.out.println(allMovies [7] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate documentary movies (7 records)":
                    //display documentary movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [8] [documentaryIndex-i]);
                            documentaryIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        documentaryIndex = 0;
                        for (int i = 0; i<allMovies[8].length; i++){
                            System.out.println(allMovies [8] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate fantasy movies (3 records)":
                    //display fantasy movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [9] [fantasyIndex-i]);
                            fantasyIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        fantasyIndex = 0;
                        for (int i = 0; i<allMovies[9].length; i++){
                            System.out.println(allMovies [9] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate mystery movies (3 records)":
                    //display mystery movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [10] [mysteryIndex-i]);
                            mysteryIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        mysteryIndex = 0;
                        for (int i = 0; i<allMovies[10].length; i++){
                            System.out.println(allMovies [10] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    case "n Navigate romance movies (1 records)":
                    //display romance movies

                    try{
                        for (int i = 0; i<Math.abs(amount); i++){
                            System.out.println(allMovies [11] [romanceIndex-i]);
                            romanceIndex --;
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("BOF has been reached");
                        romanceIndex = 0;
                        for (int i = 0; i<allMovies[11].length; i++){
                            System.out.println(allMovies [11] [i]);
                        }
                    }
                    finally{
                        mainMenu();
                    }
                    break;

                    default:
                    System.out.println("There are no records to display");
                    mainMenu();
                }

            }
        }


    }




