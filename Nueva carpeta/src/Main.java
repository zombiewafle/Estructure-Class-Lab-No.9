import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BufferedReader input = null;
        System.out.println("Please insert the txt file that contains the matrix");
        String path = sc.nextLine();
        String nm;

        try{
            input = new BufferedReader(new FileReader(path));
            while ((nm = input.readLine()) != null){
                String[] rows = path.trim().split(";");

                int numberOfRows = rows.length;
                int numeroOfColumns = rows[0].trim().split(" ").length;

                int[][] result = new int[numberOfRows][numeroOfColumns];

            }
        }catch (IOException e){
            System.out.println("Error, was not found");
        }

    }
}


