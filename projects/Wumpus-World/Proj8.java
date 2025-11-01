/**
 * Main class - runs the Wumpus World game.
 * @author Sanskar Luitel
 * @version 8
 * Lab tue/thur
 */
public class Proj8 {
    /**
     * Starts the whole game. Checks for cheat mode, makes the board and view,
     * and runs the main game loop until the game ends.
     *
     * @param args takes command line input (use "--cheat" to show board info)
     */
    public static void main(String[] args) {
        //check if player started game with --cheat option
        boolean cheat = args.length > 0 && args[0].equalsIgnoreCase("--cheat");

        //create the board and view objects
        Board board = new Board(cheat);
        View view = new View();

        //show first set of hints
        view.show(board.getHints());

        //main game loop
        while (!board.isGameOver()) {
            if (cheat) board.showCheat();  //print the hidden info if cheat mode is on

            //ask the player what they want to do
            char action = view.getAction();

            switch (action) {
                case 'm':
                    char dir = view.getDirection();
                    view.show(board.move(dir));
                    break;
                case 's':
                    dir = view.getDirection();
                    view.show(board.shoot(dir));
                    break;
                case 'g':
                    view.show(board.grab());
                    break;
                case 'c':
                    view.show(board.climb());
                    break;
                default:
                    view.show("Invalid command.\n");
            }
        }
    }
}
