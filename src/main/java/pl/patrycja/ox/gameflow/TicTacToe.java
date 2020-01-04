package pl.patrycja.ox.gameflow;

import java.util.List;

/**
 * A class TicTacToe presents a main class.
 *
 * @author Patrycja Hyjek
 */
class TicTacToe {

    /**
     * This method is called whenever we start a new game.
     *
     * @param args is string's array which are put on the beginning of game
     */
    public static void main(String[] args) {

        FactoryMode factoryMode = new FactoryMode(getLessThanFour(args));
        Mode mode = factoryMode.setMode();
        mode.settings(args);
        List<Player> players = mode.createPlayers();
        mode.play(players);
    }

    private static int getLessThanFour(String[] args) {
        return Math.min(args.length, 3);
    }
}
