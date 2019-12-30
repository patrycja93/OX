package pl.patrycja.ox.board;

import pl.patrycja.ox.Observable;
import pl.patrycja.ox.Sign;

/**
 * A class can implement the Board interface when it
 * wants make an operations on the board.
 *
 * @author Patrycja Hyjek
 */

public interface Board extends Observable {
    /**
     * This method is called whenever we want to add a sign to the board.
     *
     * @param fieldNumber is a number of field in board where we want to add a sign
     * @param sign        an argument which will be added to board
     */
    boolean putSignToBoard(int fieldNumber, Sign sign);

    /**
     * This method is called whenever we want to delete from the board all signs.
     */
    void clean();
}
