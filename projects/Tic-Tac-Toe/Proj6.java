/**
 * (Connect-Four game)
 * 
 * @author (Sanskar luitel)
 * @version (6)
 */
import java.util.*;
import java.io.*;

public class Proj6 {
    public static Scanner s = new Scanner(System.in);

    //2d array as global variable
    static char[][] board = new char[6][7];

/**
 * (This is the main method and this controls the main game)
 * 
 * 
 * since it's void, nothing is being returned
 */
    public static void main(String[] args) {
        s = new Scanner(System.in);

        //create the board
        //outer loop through rows
        //inner loop through columns
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }

        

        //current player
        char curPlayer = 'O';
        int curUserNumber = 1;

        //game loop to run until the player wins or the board is full
        while(true) {
            //print the board 
            printBoard();

            userInputAndValidation(curPlayer, curUserNumber);

            if (ifWonYet(curPlayer)) {
                System.out.printf("User %d wins (%c)",curUserNumber,curPlayer);
                break;
            }

            if(isBoardFull()) {
                System.out.println("Game is tie!");
                break;
            }

            if (curPlayer == 'O') {
                curPlayer = 'X';
                curUserNumber = 2;
            } else {
                curPlayer = 'O';
                curUserNumber = 1;
            }


        }

        


    }

    /**
     * method to ask for user input and validate
     *
     * @param curPlayer      The current player's symbol ('O' or 'X')
     * @param curUserNumber  The current user's number (1 or 2)
     */


    
    public static void userInputAndValidation(char curPlayer, int curUserNumber) {
        int column;
        while (true) {
            System.out.printf("User %d (%c), enter a column (0-6): ", curUserNumber, curPlayer);
            column = s.nextInt();
            System.out.println();

            // Check input number
            if (column < 0 || column > 6) {
                System.out.println("Invalid column number");
                continue; 
            }

            if (board[0][column] != '_') {
                System.out.println("The column is full.");
                continue; 
            }

            // Place the piece 
            for (int i = 5; i >= 0; i--) {
                if (board[i][column] == '_') {
                    board[i][column] = curPlayer;
                    break;
                }
            }

            break;  
        }
    }

    /**
     * method to check if the player has won
     *
     * @param curPlayer  The current player's symbol ('O' or 'X')
     * @return           True if the player has four in a row, otherwise false
     */

    
    public static boolean ifWonYet(char curPlayer) {

    
        //horizontal win check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] == curPlayer &&
                    board[i][j+1] == curPlayer &&
                    board[i][j+2] == curPlayer &&
                    board[i][j+3] == curPlayer) {
                    return true;
                }
            }
        }

        // vertical win check
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == curPlayer &&
                    board[i+1][j] == curPlayer &&
                    board[i+2][j] == curPlayer &&
                    board[i+3][j] == curPlayer) {
                    return true;
                }
            }
        }

        // Diagonal down right check \
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] == curPlayer &&
                    board[i+1][j+1] == curPlayer &&
                    board[i+2][j+2] == curPlayer &&
                    board[i+3][j+3] == curPlayer) {
                    return true;
                }
            }
        }

        // Diagonal down left check /
        for (int i = 0; i <= 2; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j] == curPlayer &&
                    board[i+1][j-1] == curPlayer &&
                    board[i+2][j-2] == curPlayer &&
                    board[i+3][j-3] == curPlayer) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * method to check if the board is full
     *
     * @return  True if the board is full, otherwise false
     */

    
    public static boolean isBoardFull(){
        for( int i = 0; i < 7; i++ ) {
            if ( board[0][i] == '_' ) {
                return false;
            }  
        }
        return true;
    }

    /**
     * method to print board
     *
     * No parameters or return value.
     */
    
    public static void printBoard() {
        System.out.println("Current Board (user1 = O, user2 = X):");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }



}
