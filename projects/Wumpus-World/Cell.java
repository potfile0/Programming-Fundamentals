/**
 * Cell class holds info about what’s in each spot on the board
 * can have wumpus, pit, or gold
 * @author Sanskar Luitel
 * @version 8
 * Lab tue/thur
 */
public class Cell {
    private boolean wumpus;
    private boolean pit;
    private boolean gold;

    /**
     * Makes a new empty cell with no Wumpus, no pit, and no gold.
     */
    public Cell() {
        wumpus = false;
        pit = false;
        gold = false;
    }

    /**
     * Checks if there is a Wumpus in this cell.
     *
     * @return true if there is a Wumpus, false otherwise
     */
    public boolean hasWumpus() { 
        return wumpus; 
    }

    /**
     * Checks if there is a pit in this cell.
     *
     * @return true if there is a pit, false otherwise
     */
    public boolean hasPit() {
         return pit; 
    }

    /**
     * Checks if there is gold in this cell.
     *
     * @return true if there is gold, false otherwise
     */
    public boolean hasGold() { 
        return gold; 
    }

    /**
     * Sets whether this cell has a Wumpus or not.
     *
     * @param x true to place a Wumpus, false to remove it
     */
    public void setWumpus(boolean x) {
        wumpus = x; 
    }

    /**
     * Sets whether this cell has a pit or not.
     *
     * @param x true to place a pit, false to remove it
     */
    public void setPit(boolean x) {
        pit = x; 
    }

    /**
     * Sets whether this cell has gold or not.
     *
     * @param x true to place gold, false to remove it
     */
    public void setGold(boolean x) {
        gold = x; 
    }
}
