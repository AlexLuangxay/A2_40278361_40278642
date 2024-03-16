import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class PartTwo{
    
    
    public void do_part2(String part2manifest){
        Scanner txt = null;
        Scanner csv = null;
        ObjectOutputStream outputStream = null;
        csv.useDelimiter(",");
        int txtLineCount = 0;
        int csvMovieCount = 0;

        try{
        
        txt = new Scanner(new FileInputStream(part2manifest));

        outputStream = new ObjectOutputStream( new FileOutputStream("part3_manifest.txt"));
        
        }

        catch(FileNotFoundException e){
                System.out.println("The file was not found");
        }
        catch(IOException e){

        System.out.println("A reading error occured");
        }

        while (txt.hasNextLine()){
            txtLineCount++;
        }

        while (txt.hasNextLine()){
           
            String line = txt.nextLine();
            try
            {

                csv = new Scanner(new FileInputStream(line));
            }   
            catch(FileNotFoundException e)
            {
            System.out.println("The csv file was not found");
            }

            while(csv.hasNextLine()){
                csvMovieCount++;
                csv.nextLine();
            }
      
            Movie [] movies = new Movie[csvMovieCount];
        
                for (int i = 0; i<movies.length && (csv.hasNextLine()); i++){

                    int year = csv.nextInt();
                    String title = csv.next();
                    int length = csv.nextInt();
                    String genre = csv.next();
                    String rating = csv.next();
                    double score = csv.nextDouble();
                    String director = csv.next();
                    String actor1 = csv.next();
                    String actor2 = csv.next();
                    String actor3 = csv.next();

                    movies [i] = new Movie(year, title, length, genre, rating, score, director, actor1, actor2, actor3);
                    
                    
                    //write to binary file here
        }
    
    }
    
            csv.close();
            txt.close();
    }
}
