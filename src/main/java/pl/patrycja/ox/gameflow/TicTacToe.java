package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Player;

import java.util.List;

/**
 * A class TicTacToe presents a main class.
 *
 * @author Patrycja Hyjek
 */
class TicTacToe {

    private static final int MAXIMUM_AMOUNT_OF_PARAMETERS = 3;

    /**
     * This method is called whenever we start a new game.
     *
     * @param args is string's array which are put on the beginning of game
     */
    public static void main(String[] args) {

        ModeFactory modeFactory = new ModeFactory(getLessThanFour(args), args);
        Mode mode = modeFactory.setMode();
        mode.settings(args);
        List<Player> players = mode.createPlayers();
        mode.play(players);
    }

    private static int getLessThanFour(String[] args) {
        return Math.min(args.length, MAXIMUM_AMOUNT_OF_PARAMETERS);
    }
}
