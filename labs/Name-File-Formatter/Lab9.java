import java.util.*;
import java.io.*;

public class Lab9 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the name of the file you want to connect?: ");

        String filename = s.nextLine();

        Scanner inFile = new Scanner (new File(filename));

        while(inFile.hasNext()){
            String line = inFile.nextLine();
            String [] pieces = line.split("\\s+");

            StringBuilder build = new StringBuilder();

            if (pieces.length == 1 ){
                build.append(pieces[0]);
            } else if (pieces.length == 2) {
                build.append(pieces[1]);
                build.append(", ");
                build.append(pieces[0]);
            } else if (pieces.length >= 3) {
                build.append(pieces[pieces.length - 1]); 
                build.append(", ");
                build.append(pieces[0]); 
                build.append(" ");
                build.append(pieces[1].charAt(0)); 
                build.append(".");
            }

            System.out.println(build.toString());
        }

        inFile.close(); 
        
    }
    
}
