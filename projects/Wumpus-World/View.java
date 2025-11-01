import java.util.*;

/**
 * Handles user input and printing messages.
 * @author Sanskar Luitel
 * @version 8
 * Lab tue/thur
 */
public class View {
    private Scanner s;

    /**
     * Makes a new View that reads input from the keyboard.
     */
    public View() {
        s = new Scanner(System.in);
    }

    /**
     * Asks the user what action they want to do.
     *
     * @return the letter for the action (m, s, g, or c)
     */
    public char getAction() {
        System.out.print("Enter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
        return s.nextLine().trim().toLowerCase().charAt(0);
    }

    /**
     * Asks the user which direction they want to go or shoot.
     *
     * @return the letter for direction (u, d, l, or r)
     */
    public char getDirection() {
        System.out.print("Enter direction (u)p, (d)own, (l)eft, (r)ight: ");
        return s.nextLine().trim().toLowerCase().charAt(0);
    }

    /**
     * Prints a message to the screen.
     *
     * @param msg the message that should be printed
     */
    public void show(String msg) {
        System.out.print(msg);
    }
}
