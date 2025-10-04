/**
 * a text-based version of the popular puzzle game Wordle.
 *
 * @author Sanskar Luitel
 * @version 5
 */
import java.util.*;
import java.io.*;

public class Proj5{
    public static void main(String[] args)throws IOException{
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        //Game banner print
        System.out.println("Welcome to text-based Wordle! You get 6 tries to guess a five-letter word.");
        System.out.println("Each guess must be a valid English word.");
        System.out.println("After each guess, you will get feedback for each letter in your guess.");
        System.out.println("\"G\" means that letter appears at that position in the correct word.");
        System.out.println("\"Y\" means that letter appears at a different position in the correct word.");
        System.out.println("\"B\" means that letter does not appear in the correct word.");
    
        //finding the number of line inside the "puzzles" file and them into string array
        Scanner inFile = new Scanner (new File("puzzles.txt"));
        
        int puzzles_word_count = 0;
        while (inFile.hasNextLine()) {
            inFile.nextLine();
            puzzles_word_count++;
        }

        String[] puzzles = new String[puzzles_word_count];

        //reset the inFile Scanner
        inFile = new Scanner(new File("puzzles.txt"));

        //Picks a random puzzle word from puzzle.txt with each run of program, which can be printed with the "cheat" option
        int index = 0;

        while (inFile.hasNextLine()) {
            puzzles[index] = inFile.nextLine();  
            index++;
        }

        inFile.close();  

        String randomWord = puzzles[r.nextInt(puzzles.length)];

        //to store the allowed words into an array "allowed_words"
        Scanner inFile2 = new Scanner(new File("allowed.txt"));
        
        int allowed_word_count = 0;
        while (inFile2.hasNextLine()) {
            inFile2.nextLine();
            allowed_word_count++;
        }
        inFile2.close();

        String[] allowed_words = new String [allowed_word_count];
        inFile2 = new Scanner(new File("allowed.txt"));
        for (int i = 0; i < allowed_word_count; i++) {
            allowed_words[i] = inFile2.nextLine();
        }
        inFile2.close();

        //Asks user if they want to use cheat mode
        System.out.print("\nDo you want to enter \"cheat mode\", where you know the correct word ahead of time? (y/n) ");
        char response = s.nextLine().toLowerCase().charAt(0);
        if ( response == 'y') {
            System.out.printf("\nThe correct word is \" %s \"", randomWord );
        } 

        //asking user for guess
        
        int guess_counter = 1;
        boolean found;
        boolean guessed_correctly = false;
        while ( guess_counter <= 6 ) {
            found = false;
            System.out.printf("\nEnter guess #%d: ", guess_counter);
            String guess = s.nextLine();

            //check if the user input is inside of the 2 files 
            

                for ( int i = 0; i < puzzles.length; i++) {
                    if ( puzzles[i].equalsIgnoreCase(guess)) {
                        found = true;
                        break;
                    } 
                }
                if ( found == false ){
                    for ( int i = 0; i < allowed_words.length; i++) {
                        if (allowed_words[i].equalsIgnoreCase(guess)) {
                            found = true;
                            break;
                        }
                    }
                }
                if ( found == false ){
                    System.out.printf("%s is not a valid word", guess);
                    continue;
                }


                System.out.println("Feedback:");

                String[] characters = guess.split("");
                System.out.print("\t");
                for (int i = 0; i < guess.length(); i++) {
                    System.out.print(characters[i]);
                    System.out.print(" ");
                }
                System.out.println();


                char[] feedback = new char[5];
                //marked all letters to B first
                for (int i = 0; i < feedback.length; i++) {
                    feedback[i] = 'B';
                }

                //converting the randomWord and GuessWord to array
                String[] random_worrd_array = randomWord.split("");
                String[] guess_array = guess.split("");

                //to check for G
                for (int i = 0; i < guess.length(); i++ ) {
                    if ( guess_array[i].equalsIgnoreCase(random_worrd_array[i])){
                        feedback[i] = 'G';
                        random_worrd_array[i] = "*";

                    }
                }

                //to check for Y
                for (int i = 0; i < guess.length(); i++ ) {
                    if (feedback[i] == 'B' ) {
                        for (int j = 0; j < random_worrd_array.length; j++ ){
                            if (guess_array[i].equalsIgnoreCase(random_worrd_array[j])) {
                                feedback[i] = 'Y';
                                random_worrd_array[j] = "*";  
                                guess_array[i] = "#";
                                break;
                            }
                        }
                    }

                }
                System.out.print("\t");
                for (int i = 0; i < feedback.length; i++) {
                    System.out.print(feedback[i] + " ");
                }
                System.out.println();

                //win condition check
                boolean isCorrect = true;
                for (char c : feedback) {
                    if (c != 'G') {
                        isCorrect = false;
                        break;
                    }
                }
                if (isCorrect) {
                    System.out.printf("Correct, the answer is %s. It took you %d guesses.\n", randomWord, guess_counter);
                    guessed_correctly = true;
                    break;
                } else {
                    guess_counter++;
                }
        } 
        if (guessed_correctly == false ) {
            if ( guess_counter > 6 ){
                System.out.printf("You are out of guesses. The answer was %s", randomWord);
            }
        }
    }
}