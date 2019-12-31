package pl.patrycja.ox.gameflow;

/**
 * A class TicTacToe presents a main class.
 *
 * @author Patrycja Hyjek
 */
class TicTacToe {

    /**
     * This method is called whenever we start a new game.
     * @param args is string's array which are put on the beginning of game
     */
    public static void main(String[] args) {
        boolean ifDemo = checkIfDemo(args);
        Game game = new Game(ifDemo);
        game.play();
    }

    private static boolean checkIfDemo(String[] args) {
        return args.length > 0 && args[0].equals("demo");
    }
}
