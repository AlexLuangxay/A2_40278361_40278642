import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

   static String choiceN = "n Navigate musical movies (0 records)";
            private static int comedyIndex = 0;
            private static int animationIndex = 0;
            private static int adventureIndex = 0;
            private static int dramaIndex = 0;
            private static int crimeIndex = 0;
            private static int biographyIndex = 0;
            private static int horrorIndex = 0;
            private static int actionIndex = 0;
            private static int documentaryIndex = 0;
            private static int fantasyIndex = 0;
            private static int familyIndex = 0;

   


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

        Movie.do_part3(manifest_part3);
        
        allMovies = Movie.do_part3(manifest_part3);

        mainMenu();


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
        //sin.close();
        if (choice.equals("s")) {    //select movie array to navigate
            navigationMenu();
        } else if (choice.equals("n")) {          //n Navigate specific movie genre            
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
        System.out.println("2 comedy (172 movies)");
        System.out.println("3 animation (5 movies)");
        System.out.println("4 adventure (39 movies)");
        System.out.println("5 drama (100 movies)");
        System.out.println("6 crime (50 movies)");
        System.out.println("7 biography (24 movies)");
        System.out.println("8 horror (14 movies)");
        System.out.println("9 action (159 movies)");
        System.out.println("10 documentary (2 movies)");
        System.out.println("11 fantasy (8 movies)");
        System.out.println("12 mystery (0 movies)");
        System.out.println("13 sci-fi (0 movies)");
        System.out.println("14 family (1 movies)");
        System.out.println("15 western (0 movies)");
        System.out.println("16 romance (0 movies)");
        System.out.println("17 thriller (0 movies)");
        System.out.println("18 Exit");
        System.out.println("------------------------------");

        Scanner in = new Scanner (System.in);
        String choice = in.nextLine();
        //in.close();
        switch (choice){
            case "1":

            choiceN = "n Navigate musical movies (0 records)";
            mainMenu();
            break;

            case "2":
            choiceN = "n Navigate comedy movies (172 records)";
            mainMenu();
            break;

            case "3":
            choiceN = "n Navigate animation movies (5 records)";
            mainMenu();
            break;

            case "4":
            choiceN = "n Navigate adventure movies (39 records)";
            mainMenu();
            break;

            case "5":
            choiceN = "n Navigate drama movies (100 records)";
            mainMenu();
            break;

            case "6":
            choiceN = "n Navigate crime movies (50 records)";
            mainMenu();
            break;

            case "7":
            choiceN = "n Navigate biography movies (24 records)";
            mainMenu();
            break;

            case "8":
            choiceN = "n Navigate horror movies (14 records)";
            mainMenu();
            break;

            case "9":
            choiceN = "n Navigate action movies (159 records)";
            mainMenu();
            break;

            case "10":
            choiceN = "n Navigate documentary movies (2 records)";
            mainMenu();
            break;

            case "11":
            choiceN = "n Navigate fantasy movies (8 records)";
            mainMenu();
            break;

            case "12":
            choiceN = "n Navigate mystery movies (0 records)";
            mainMenu();
            break;

            case "13":
            choiceN = "n Navigate sci-fi movies (0 records)";
            mainMenu();
            break;

            case "14":
            choiceN = "n Navigate family movies (1 records)";
            mainMenu();
            break;

            case "15":
            choiceN = "n Navigate western movies (0 records)";
            mainMenu();
            break;

            case "16":
            choiceN = "n Navigate romance movies (0 records)";
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
            mainMenu();
            break;

        }
    }

    public static void navigateGenre(){         //choice n

        switch (choiceN){
            case "n Navigate musical movies (0 records)":
            System.out.println("No records found");
            mainMenu();
            break;

            case "n Navigate comedy movies (172 records)":
                System.out.println("Navigating comedy movies (172 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate animation movies (5 records)":
                System.out.println("Navigating animation movies (5 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate adventure movies (39 records)":
                System.out.println("Navigating adventure movies (39 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate drama movies (100 records)":
                System.out.println("Navigating drama movies (100 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate crime movies (50 records)":
                System.out.println("Navigating crime movies (50 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate biography movies (24 records)":
                System.out.println("Navigating biography movies (24 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate horror movies (14 records)":
                System.out.println("Navigating horror movies (14 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate action movies (159 records)":
                System.out.println("Navigating action movies (71 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate documentary movies (2 records)":
                System.out.println("Navigating documentary movies (2 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;

            case "n Navigate fantasy movies (8 records)":
                System.out.println("Navigating fantasy movies (8 records)");
                System.out.print("Enter choice: ");
                displayMovies();
                break;
            
            case "n Navigate mystery movies (0 records)":
            System.out.println("No records found");
            mainMenu();
                break;

            case "n Navigate sci-fi movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;
            
            case "n Navigate family movies (1 records)":
                System.out.println("No records found");
                mainMenu();
                break;

            case "n Navigate western movies (0 records)":
                System.out.println("No records found");
                mainMenu();
                break;

            case "n Navigate romance movies (0 records)":
            System.out.println("No records found");
            mainMenu();
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

            int amount = Math.abs(choice);
            
            
           
            if (choice == 0){
                mainMenu();
            }

            if (choice>0){
           
            comedyIndex += amount-1;         //final index to display
            animationIndex += amount-1;
            adventureIndex += amount-1;
            dramaIndex += amount-1;
            crimeIndex += amount-1;
            biographyIndex += amount-1;
            horrorIndex += amount-1;
            actionIndex += amount-1;
            documentaryIndex += amount-1;
            fantasyIndex += amount-1;
            familyIndex += amount-1;

                switch (choiceN){
                    case "n Navigate comedy movies (172 records)":
                    //display comedy movies
                    
                    if (comedyIndex<allMovies [1].length){    
                        for (int i = comedyIndex-amount+1; i<=comedyIndex; i++){
                            System.out.println(allMovies [1] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        comedyIndex = comedyIndex-amount+1;
                        for (int i = comedyIndex; i<allMovies[1].length-comedyIndex; i++){
                            System.out.println(allMovies [1] [i]);
                        }
                        comedyIndex = allMovies[1].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate animation movies (5 records)":
                    //display animation movies
                    if (animationIndex<allMovies [2].length){    
                        for (int i = animationIndex-amount+1; i<=animationIndex; i++){
                            System.out.println(allMovies [2] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        animationIndex = animationIndex-amount+1;
                        for (int i = animationIndex; i<allMovies[2].length-animationIndex; i++){
                            System.out.println(allMovies [2] [i]);
                        }
                        animationIndex = allMovies[2].length-1;
                    }
                    mainMenu();

                    break;

                    case "n Navigate adventure movies (39 records)":
                    //display adventure movies

                    if (adventureIndex<allMovies [3].length){    
                        for (int i = adventureIndex-amount+1; i<=adventureIndex; i++){
                            System.out.println(allMovies [3] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        adventureIndex = adventureIndex-amount+1;
                        for (int i = adventureIndex; i<allMovies[3].length-adventureIndex; i++){
                            System.out.println(allMovies [3] [i]);
                        }
                        adventureIndex = allMovies[3].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate drama movies (100 records)":
                    //display drama movies

                    if (dramaIndex<allMovies [4].length){    
                        for (int i = dramaIndex-amount+1; i<=dramaIndex; i++){
                            System.out.println(allMovies [4] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        dramaIndex = dramaIndex-amount+1;
                        for (int i = dramaIndex; i<allMovies[4].length-dramaIndex; i++){
                            System.out.println(allMovies [4] [i]);
                        }
                        dramaIndex = allMovies[4].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate crime movies (50 records)":
                    //display crime movies

                    if (crimeIndex<allMovies [5].length){    
                        for (int i = crimeIndex-amount+1; i<=crimeIndex; i++){
                            System.out.println(allMovies [5] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        crimeIndex = crimeIndex-amount+1;
                        for (int i = crimeIndex; i<allMovies[5].length-crimeIndex; i++){
                            System.out.println(allMovies [5] [i]);
                        }

                        crimeIndex = allMovies[5].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate biography movies (24 records)":
                    //display biography movies

                    if (biographyIndex<allMovies [6].length){    
                        for (int i = biographyIndex-amount+1; i<=biographyIndex; i++){
                            System.out.println(allMovies [6] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        biographyIndex = biographyIndex-amount+1;
                        for (int i = biographyIndex; i<allMovies[6].length-biographyIndex; i++){
                            System.out.println(allMovies [6] [i]);
                        }

                        biographyIndex = allMovies[6].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate horror movies (14 records)":
                    //display horror movies

                    if (horrorIndex<allMovies [7].length){    
                        for (int i = horrorIndex-amount+1; i<=horrorIndex; i++){
                            System.out.println(allMovies [7] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        horrorIndex = horrorIndex-amount+1;
                        for (int i = horrorIndex; i<allMovies[7].length-horrorIndex; i++){
                            System.out.println(allMovies [7] [i]);
                        }

                        horrorIndex = allMovies[7].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate action movies (159 records)":
                    //display action movies

                    if (actionIndex<allMovies [8].length){    
                        for (int i = actionIndex-amount+1; i<=actionIndex; i++){
                            System.out.println(allMovies [8] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        actionIndex = actionIndex-amount+1;
                        for (int i = actionIndex; i<allMovies[8].length-actionIndex; i++){
                            System.out.println(allMovies [8] [i]);
                        }

                        actionIndex = allMovies[8].length-1;
                    }
                    break;

                    case "n Navigate documentary movies (2 records)":
                    //display documentary movies

                    if (documentaryIndex<allMovies [9].length){    
                        for (int i = documentaryIndex-amount+1; i<=documentaryIndex; i++){
                            System.out.println(allMovies [9] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        documentaryIndex = documentaryIndex-amount+1;
                        for (int i = documentaryIndex; i<allMovies[9].length-documentaryIndex; i++){
                            System.out.println(allMovies [9] [i]);
                        }

                        documentaryIndex = allMovies[9].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate fantasy movies (8 records)":
                    //display fantasy movies

                    if (fantasyIndex<allMovies [10].length){    
                        for (int i = fantasyIndex-amount+1; i<=fantasyIndex; i++){
                            System.out.println(allMovies [10] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        fantasyIndex = fantasyIndex-amount+1;
                        for (int i = fantasyIndex; i<allMovies[10].length-fantasyIndex; i++){
                            System.out.println(allMovies [10] [i]);
                        }

                        fantasyIndex = allMovies[10].length-1;
                    }
                    mainMenu();
                    break;

                    case "n Navigate family movies (1 records)":
                    //display mystery movies

                    if (familyIndex<allMovies [13].length){    
                        for (int i = familyIndex-amount+1; i<=familyIndex; i++){
                            System.out.println(allMovies [13] [i]);
                        }
                    }
                    else{
                        System.out.println("EOF has been reached");
                        familyIndex = familyIndex-amount+1;
                        for (int i = familyIndex; i<allMovies[13].length-familyIndex; i++){
                            System.out.println(allMovies [13] [i]);
                        }

                        familyIndex = allMovies[13].length-1;
                    }
                    mainMenu();
                    break;

                    default:
                    System.out.println("There are no records to display");
                    mainMenu();
                }
            }

            if (choice <0){ 
                                                         //need to change the part when exception is found
                
                comedyIndex -= amount-1;
                animationIndex -= amount-1;
                adventureIndex -= amount-1;
                dramaIndex -= amount-1;
                crimeIndex -= amount-1;
                biographyIndex -= amount-1;
                horrorIndex -= amount-1;
                actionIndex -= amount-1;
                documentaryIndex -= amount-1;
                fantasyIndex -= amount-1;
                familyIndex -= amount-1;

                switch (choiceN){

                    case "n Navigate comedy movies (172 records)":
                    //display comedy movies

                    if (comedyIndex>=0){
                        for (int i = comedyIndex+amount-1; i>=comedyIndex; i--){
                            System.out.println(allMovies [1] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = comedyIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [1] [i]);
                        }
                        comedyIndex = 0;
                    }

                    mainMenu();
                    break;

                    case "n Navigate animation movies (5 records)":
                    //display animation movies

                    if (animationIndex>=0){
                        for (int i = animationIndex+amount-1; i>=animationIndex; i--){
                            System.out.println(allMovies [2] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = animationIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [2] [i]);
                        }
                        animationIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate adventure movies (39 records)":
                    //display adventure movies

                    if (adventureIndex>=0){
                        for (int i = adventureIndex+amount-1; i>=adventureIndex; i--){
                            System.out.println(allMovies [3] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = adventureIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [3] [i]);
                        }
                        adventureIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate drama movies (100 records)":
                    //display drama movies

                    if (dramaIndex>=0){
                        for (int i = dramaIndex+amount-1; i>=dramaIndex; i--){
                            System.out.println(allMovies [4] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = dramaIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [4] [i]);
                        }
                        dramaIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate crime movies (50 records)":
                    //display crime movies

                    if (crimeIndex>=0){
                        for (int i = crimeIndex+amount-1; i>=crimeIndex; i--){
                            System.out.println(allMovies [5] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = crimeIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [5] [i]);
                        }
                        crimeIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate biography movies (24 records)":
                    //display biography movies

                    if (biographyIndex>=0){
                        for (int i = biographyIndex+amount-1; i>=biographyIndex; i--){
                            System.out.println(allMovies [6] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = biographyIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [6] [i]);
                        }
                        biographyIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate horror movies (14 records)":
                    //display horror movies

                    if (horrorIndex>=0){
                        for (int i = horrorIndex+amount-1; i>=horrorIndex; i--){
                            System.out.println(allMovies [7] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = horrorIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [7] [i]);
                        }
                        horrorIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate action movies (159 records)":
                    //display action movies

                    if (actionIndex>=0){
                        for (int i = actionIndex+amount-1; i>=actionIndex; i--){
                            System.out.println(allMovies [8] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = actionIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [8] [i]);
                        }
                        actionIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate documentary movies (2 records)":
                    //display documentary movies

                    if (documentaryIndex>=0){
                        for (int i = documentaryIndex+amount-1; i>=documentaryIndex; i--){
                            System.out.println(allMovies [9] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = documentaryIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [9] [i]);
                        }
                        documentaryIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate fantasy movies (8 records)":
                    //display fantasy movies

                    if (fantasyIndex>=0){
                        for (int i = fantasyIndex+amount-1; i>=fantasyIndex; i--){
                            System.out.println(allMovies [10] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = fantasyIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [10] [i]);
                        }
                        fantasyIndex = 0;
                    }
                    mainMenu();
                    break;

                    case "n Navigate family movies (1 records)":
                    //display mystery movies

                    if (familyIndex>=0){
                        for (int i = familyIndex+amount-1; i>=familyIndex; i--){
                            System.out.println(allMovies [13] [i]);
                        }
                    }
                    else{
                        System.out.println("BOF has been reached");
                        for (int i = familyIndex+amount-1; i>=0; i--){
                            System.out.println(allMovies [13] [i]);
                        }
                        familyIndex = 0;
                    }
                    mainMenu();
                    break;
                    
                default:
                    System.out.println("There are no records to display");
                    mainMenu();
                }

            }
            
            in.close();
        }


    }




