import java.util.*;

public class Lab12 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        s = new Scanner(System.in);
       /* play text-based Tic-Tac-Toe, with board like:
         
         - - - 
         - - - 
         - - - 
        */

         // current turn
        char turn = 'X';

        // has someone won?
        boolean winner = false;

        char[][] board = createBoard();

        while (!isFull(board)) {
            printBoard(board);

            int row = getRow(turn);
            int col = getCol(turn);

            if (isValidMove(board, row, col)) {
                board[row][col] = turn;

                if (isWinner(board, turn)) {
                    printBoard(board);
                    System.out.printf("%c wins!%n", turn);
                    winner = true;
                    break;
                }

                // Switch turns
                turn = (turn == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        if (!winner) {
            printBoard(board);
            System.out.println("It's a tie game!");
        }

        
    }

    // create board
    public static char[][] createBoard() {
        char board [][] = new char[3][3];
        // board.length: # rows
        // board[i].length: # columns

        // outer loop through rows
        // inner loop through columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
        return board;
    }

    // print the board
    public static void printBoard (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }
    

    //check if board is full
    public static boolean isFull(char[][] board) {
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '_') {
                return false;
                }
            }
        }
        return true;
    }
      
    //get row input from user
    public static int getRow(char turn) {
        System.out.printf("%c, enter row (0, 1, or 2): ", turn);
        int row = s.nextInt();
        return row;
    }
    
    //get column input from user
    public static int getCol(char turn) {
        System.out.printf("%c, enter column (0, 1, or 2): ", turn);
        int col = s.nextInt();
        return col;
    }

    //check if a move is valid
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid input! Row and column must be between 0 and 2.");
            return false;
        }
        if (board[row][col] != '_') {
            System.out.println("Invalid move! That spot is already taken.");
            return false;
        }
        return true;
    }

    //check if the current player won
    public static boolean isWinner(char[][] board, char turn) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn) {
                return true;
            }
            if (board[0][i] == turn && board[1][i] == turn && board[2][i] == turn) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
            return true;
        }

        if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
            return true;
        }

        return false;
    }
        
}
