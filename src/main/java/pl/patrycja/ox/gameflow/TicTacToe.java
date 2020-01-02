package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

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
        UI ui = UIFactory.set(ifDemo);

        Game game = new Game(ui);
        game.play();
    }

    private static boolean checkIfDemo(String[] args) {
        return args.length > 0 && args[0].equals("demo");
    }
}
