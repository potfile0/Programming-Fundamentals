/**
 * Player class keeps track of where the player is and what they have
 * 
 * @author Sanskar Luitel
 * @version 8
 * Lab tue/thur
 */
public class Player {
    private int row;
    private int col;
    private boolean arrow;
    private boolean gold;

    /**
     * Makes a new player starting in a given spot.
     *
     * @param startRow the row where the player starts
     * @param startCol the column where the player starts
     */
    public Player(int startRow, int startCol) {
        row = startRow;
        col = startCol;
        arrow = true;  // player starts with one arrow
        gold = false;  // player starts without gold
    }

    /**
     * Gets the player’s current row.
     *
     * @return the player’s row
     */
    public int getRow() {
        return row; 
    }

    /**
     * Gets the player’s current column.
     *
     * @return the player’s column
     */
    public int getCol() {
        return col; 
    }

    /**
     * Checks if the player still has their arrow.
     *
     * @return true if the player still has an arrow, false if not
     */
    public boolean hasArrow() {
        return arrow; 
    }

    /**
     * Checks if the player has picked up the gold.
     *
     * @return true if they have the gold, false otherwise
     */
    public boolean hasGold() {
        return gold; 
    }

    /**
     * Uses up the player’s arrow.
     */
    public void useArrow() {
        arrow = false; 
    }

    /**
     * Marks that the player has picked up the gold.
     */
    public void pickGold() {
        gold = true; 
    }

    /**
     * Moves the player up one row.
     */
    public void moveUp() {
        row--; 
    }

    /**
     * Moves the player down one row.
     */
    public void moveDown() {
        row++; 
    }

    /**
     * Moves the player left one column.
     */
    public void moveLeft() {
        col--; 
    }

    /**
     * Moves the player right one column.
     */
    public void moveRight() {
        col++; 
    }

    /**
     * Changes the player’s position to a specific row and column.
     *
     * @param r the new row
     * @param c the new column
     */
    public void setPosition(int r, int c) {
        row = r;
        col = c;
    }
}
