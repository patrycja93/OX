package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.ui.UIFactory;

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

        ModeFactory modeFactory = new ModeFactory(args);
        Mode mode = modeFactory.setMode();
        mode.settings(args);
        List<Player> players = mode.createPlayers();
        mode.play(players);
    }
}
