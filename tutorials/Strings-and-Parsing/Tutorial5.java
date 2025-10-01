import java.util.*;
import java.io.*;

public class Tutorial5 {
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);

        //example 1: concatenation, Strings in memory (immutable)
        String str = "hello";

        int size = str.length(); //this is 5

        String bigger = str + "toyou"; //str is "hellotoyou"

        str = str + "bye"; //str is "hellobye"

        //string concatenation example

        String example1 = "abracadabra";

        //goal: reverse "abracadabra"
        StringBuilder result = new StringBuilder(); //an empty StringBuilder

        for (int i = example1.length() - 1; i >= 0; i--) {
            result.append(example1.charAt(i));

            //result.append(example1.substring(i,i+1)); is equivalent


        }

        System.out.printf("%s reversed is %s%n", example1, result);


        //example 2: get word, get letter, print #occurences

        System.out.print("\nEnter a word: ");
        String word = s.nextLine();

        System.out.print("Enter a letter: ");
        String letter = s.nextLine();

        //to check the number of occurence of the letter in that word
        String[] input_words = word.split("");
        int occurence = 0;

        for (int i = 0; i < word.length(); i++){
            if (input_words[i].equals(letter) ){
                occurence += 1;
            }
        }
        if(occurence < 1){
            System.out.println("There is no occurence.");
        }else{
            System.out.printf("'%s' occured %d times in %s", letter, occurence, word);
        }


        //example 3: get fraction expression, print answer
        //user enters 2/3 + 3/4
        System.out.print("\n\nEnter fraction expression (like 2/3 + 3/4): ");
        String fraction = s.nextLine(); //fraction is something like "2/3 + 3/4"

        //assumption that the operator (like +) has spaces on both sides

         //use String split, separator/delimeter is a space

        String[] pieces = fraction.split("\\s+"); //pieces should be {"2/3", "+", "3/4"}

        //indexOf tells you what position in a bigger string some character or smaller string is
        int slash1pos = pieces[0].indexOf("/"); //for "2/3", slash1pos would be 1
        int num1 = Integer.parseInt(pieces[0].substring(0,slash1pos));
        int denom1 = Integer.parseInt(pieces[0].substring(slash1pos+1));
        
        int slash2pos = pieces[2].indexOf("/"); //for "3/4", slash2pos would be 1
        int num2 = Integer.parseInt(pieces[2].substring(0,slash1pos));
        int denom2 = Integer.parseInt(pieces[2].substring(slash1pos+1));

        int resultNum, resultDenom;
        if (pieces[1].equals("+")){
            resultDenom = denom1 * denom2;
            resultNum = num1*denom2 + num2 * denom1;

        }
        else if (pieces[1].equals("-")){
            resultDenom = denom1 * denom2;
            resultNum = num1*denom2 - num2 * denom1;
        }
        else if (pieces[1].equals("*")){
            resultDenom = denom1 * denom2;
            resultNum = num1*num2;
        }
        else{
            //assuming divide (so assumes no bad operator input)
            resultNum = num1 * denom2;
            resultDenom = num2*denom1;
        }

        //print result, 2/3 +3/4 = 17/12
        System.out.printf("%s %s %s = %d/%d%n", pieces[0], pieces[1], pieces[2], resultNum, resultDenom);


        //example 4: read file, print an output file of all words with double (adjacent) letters
        
        //connect to my input file
        Scanner inFile = new Scanner (new File("words56.txt"));

        //connect to my output file
        PrintWriter outFile = new PrintWriter("doubleLetters.txt");

        //while there is more to read in the input file
        while(inFile.hasNextLine()) {
            String line = inFile.nextLine();

            //does it have double adjacent letters?
            boolean doubleLetters = false;
            for (int i = 0; i < line.length()-1; i++) {
                //see if pos i matches the one right after it (i+1)

                if (line.charAt(i) == line.charAt(i+1)) {
                    doubleLetters = true;
                }
            }

            if (doubleLetters) {
                //print to output file
                outFile.println(line);
            }
        }

        //close connection to files
        inFile.close();
        outFile.close();
    }
}
