package pl.patrycja.ox.ui;

import java.util.Iterator;

/**
 * A class can implement the UI interface when it
 * wants to has interactions with user interface
 *
 * @author Patrycja Hyjek
 */
public interface UI {
    /**
     * This method is called whenever display sth
     *
     * @param input is a message to display
     */
    void display(Object input);

    /**
     * This method is called whenever read sth
     */
    String read();
}
