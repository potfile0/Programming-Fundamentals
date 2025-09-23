import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        /* play text-based Tic-Tac-Toe, with board like:
         
         - - - 
         - - - 
         - - - 
         */

        // create board
        char[][] board = new char[3][3];

        // board.length: # rows
        // board[i].length: # columns

        // outer loop through rows
        // inner loop through columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }

        // print the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }

        // current turn
        char turn = 'X';

        // has someone won?
        boolean winner = false;

        // 9 potential moves
        int moves = 0;
        while (moves < 9) {
            System.out.println();

            // ask the current user for a move (row/column)
            System.out.printf("%c, enter row (0, 1, or 2): ", turn);
            int row = s.nextInt();

            System.out.printf("%c, enter column (0, 1, or 2): ", turn);
            int col = s.nextInt();
            System.out.println();

            // validate the user input
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '_') {

                // put in their piece
                board[row][col] = turn;

                // print the board
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        System.out.printf("%c ", board[i][j]);
                    }
                    System.out.println();
                }

                // did they win?

                // check for row or column win
                for (int i = 0; i < 3; i++) {
                    // did they win on a row?
                    if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == turn) {
                        winner = true;
                    }

                    // did they win on a column?
                    if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == turn) {
                        winner = true;
                    }
                }

                // did they win on the / diagonal? (board[0][2], board[1][1], board[2][0])
                if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == turn) {
                    winner = true;
                }

                // did they win on the \ diagonal? (board[0][0], board[1][1], board[2][2])
                if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == turn) {
                    winner = true;
                }

                // leave game play loop if someone wins
                if (winner) break;

                // switch whose turn 
                if (turn == 'X') turn = 'O';
                else turn = 'X';

                moves++;
            } else {
                // must have been a bad move
                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid input! Row and column must be between 0 and 2.");
                } else {
                    System.out.println("Invalid move! That spot is already taken.");
                }
            }
        }

        // did someone win?
        if (winner) {
            System.out.printf("%c wins!%n", turn);
        } else {
            System.out.println("It's a tie game!");
        }

        s.close();
    }
}
