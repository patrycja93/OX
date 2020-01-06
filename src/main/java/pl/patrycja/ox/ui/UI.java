package pl.patrycja.ox.ui;

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

    default void displayError(Object message) {
        System.err.println(message);
        System.exit(0);
    }

    default void displayWarning(Object message) {
        System.out.println("[WARNING] " + message);
    }

    /**
     * This method is called whenever read sth
     */
    String read();

    int readNumber();
}
