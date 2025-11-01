import java.util.*;

/**
 * Board class makes the grid, puts everything randomly and checks what happens as the player moves.
 * @author Sanskar Luitel
 * @version 8
 * Lab tue/thur
 */
public class Board {
    private Cell[][] map;
    private Player player;
    private int rows;
    private int cols;
    private boolean wumpusAlive;
    private boolean done;
    private int wRow;
    private int wCol;
    private int gRow;
    private int gCol;
    private boolean cheat;

    public Board(boolean cheatMode) {
        cheat = cheatMode;
        Random rand = new Random();
        rows = rand.nextInt(3) + 4; //random between 4 and 6
        cols = rand.nextInt(3) + 4;

        map = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = new Cell();
            }
        }

        //player starts bottom left
        player = new Player(rows - 1, 0);

        //put wumpus
        wRow = rand.nextInt(rows);
        wCol = rand.nextInt(cols);
        while (wRow == rows - 1 && wCol == 0) {
            wRow = rand.nextInt(rows);
            wCol = rand.nextInt(cols);
        }
        map[wRow][wCol].setWumpus(true);
        wumpusAlive = true;

        //put gold
        gRow = rand.nextInt(rows);
        gCol = rand.nextInt(cols);
        while ((gRow == rows - 1 && gCol == 0) || (gRow == wRow && gCol == wCol)) {
            gRow = rand.nextInt(rows);
            gCol = rand.nextInt(cols);
        }
        map[gRow][gCol].setGold(true);

        //random pits
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == rows - 1 && j == 0) || (i == wRow && j == wCol) || (i == gRow && j == gCol))
                    continue;
                if (rand.nextInt(10) == 0)
                    map[i][j].setPit(true);
            }
        }

        done = false;
    }

    public boolean isGameOver() { return done; }

    public String getHints() {
        String msg = "";
        int r = player.getRow();
        int c = player.getCol();

        if (wumpusAlive && nextTo(r, c, wRow, wCol)) msg += "You smell a stench.\n";
        if (nextToPit(r, c)) msg += "You feel a breeze.\n";
        if (map[r][c].hasGold() && !player.hasGold()) msg += "You see a glitter.\n";

        return msg;
    }

    private boolean nextTo(int r, int c, int r2, int c2) {
        return (Math.abs(r - r2) == 1 && c == c2) || (Math.abs(c - c2) == 1 && r == r2);
    }

    private boolean nextToPit(int r, int c) {
        if (r > 0 && map[r - 1][c].hasPit()) return true;
        if (r < rows - 1 && map[r + 1][c].hasPit()) return true;
        if (c > 0 && map[r][c - 1].hasPit()) return true;
        if (c < cols - 1 && map[r][c + 1].hasPit()) return true;
        return false;
    }

    public String move(char dir) {
        int r = player.getRow();
        int c = player.getCol();

        switch (Character.toLowerCase(dir)) {
            case 'u': if (r == 0) return "There is a wall there.\n"; 
                player.moveUp(); 
                break;
            case 'd': if (r == rows - 1) return "There is a wall there.\n"; 
                player.moveDown(); 
                break;
            case 'l': if (c == 0) return "There is a wall there.\n"; 
                player.moveLeft(); 
                break;
            case 'r': if (c == cols - 1) return "There is a wall there.\n"; 
                player.moveRight(); 
                break;
            default: 
                return "Invalid direction.\n";
        }

        r = player.getRow();
        c = player.getCol();

        if (map[r][c].hasPit()) {
            done = true;
            return "You fell into a pit! Game over.\n";
        }
        if (map[r][c].hasWumpus() && wumpusAlive) {
            done = true;
            return "The Wumpus ate you! Game over.\n";
        }

        return getHints();
    }

    public String grab() {
        int r = player.getRow();
        int c = player.getCol();
        if (map[r][c].hasGold()) {
            player.pickGold();
            map[r][c].setGold(false);
            return "You grabbed the gold!\n" + getHints();
        }
        return "There is no gold here.\n";
    }

    public String shoot(char dir) {
        if (!player.hasArrow()) return "You don't have an arrow anymore.\n";

        int r = player.getRow();
        int c = player.getCol();
        boolean hit = false;

        switch (Character.toLowerCase(dir)) {
            case 'u': if (wumpusAlive && wCol == c && wRow < r) hit = true; break;
            case 'd': if (wumpusAlive && wCol == c && wRow > r) hit = true; break;
            case 'l': if (wumpusAlive && wRow == r && wCol < c) hit = true; break;
            case 'r': if (wumpusAlive && wRow == r && wCol > c) hit = true; break;
            default: return "Invalid direction.\n";
        }

        player.useArrow();
        if (hit) {
            wumpusAlive = false;
            map[wRow][wCol].setWumpus(false);
            return "You hear a scream. You killed the Wumpus!\n" + getHints();
        }
        return "You missed.\n";
    }

    public String climb() {
        if (player.getRow() == rows - 1 && player.getCol() == 0) {
            done = true;
            if (player.hasGold() && !wumpusAlive)
                return "You leave the cave with the gold! The Wumpus is dead. You win!\n";
            else if (player.hasGold())
                return "You escaped with gold but the Wumpus is alive. You lose.\n";
            else
                return "You climbed out with no gold. You lose.\n";
        }
        return "You can only climb out from the start.\n";
    }

    public void showCheat() {
        if (!cheat) return;

        System.out.println("\nCHEAT MAP");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (player.getRow() == i && player.getCol() == j)
                    System.out.print("[P] ");
                else if (map[i][j].hasWumpus())
                    System.out.print("[W] ");
                else if (map[i][j].hasPit())
                    System.out.print("[O] ");
                else if (map[i][j].hasGold())
                    System.out.print("[G] ");
                else
                    System.out.print("[ ] ");
            }
            System.out.println();
        }
        System.out.println("Gold: " + player.hasGold() + ", Arrow: " + player.hasArrow());
    }
}
