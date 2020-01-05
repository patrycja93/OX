package pl.patrycja.ox.board;

import pl.patrycja.ox.Observable;
import pl.patrycja.ox.Player;

/**
 * Enables to clean board and put a sign on the board.
 *
 * @author Patrycja Hyjek
 */

public interface Board extends Observable {
    /**
     * Called whenever we want to add a sign to the board.
     *
     * @param fieldNumber is a number of field in board where we want to add a sign
     * @param player      an argument which will be added to board
     */
    boolean putSign(int fieldNumber, Player player);

    /**
     * Called whenever we want to delete all signs from the board.
     */
    void clean();
}
