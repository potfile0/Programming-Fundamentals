import java.util.*;

public class Lab8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = s.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = s.nextInt();
        
        s.nextLine();  

        System.out.println();

        int[][] grid = new int[rows][cols];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = value++;
            }
        }

        System.out.println("Original array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%-5d", grid[i][j]);
            }
            System.out.println();
        }

        while (true) {
            System.out.println();
            System.out.print("Press 'a' to left-shift rows, or press 'q' to quit: ");
            char input = s.nextLine().charAt(0);  

            if (input == 'q') {
                break;
            } else if (input == 'a') {
                for (int i = 0; i < rows; i++) {
                    int temp = grid[i][0];
                    for (int j = 0; j < cols - 1; j++) {
                        grid[i][j] = grid[i][j + 1];
                    }
                    grid[i][cols - 1] = temp;
                }

                System.out.println("Updated array:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.printf("%-5d", grid[i][j]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
