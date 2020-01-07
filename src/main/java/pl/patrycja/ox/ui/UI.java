package pl.patrycja.ox.ui;

import pl.patrycja.ox.Sign;

/**
 * Interaction with the user.
 * Retrieves data from the input.
 *
 * @author Patrycja Hyjek
 */
public interface UI {

    /**
     * Display the error message.
     */
    default void displayError(Object message) {
        System.err.println(message);
        System.exit(0);
    }

    /**
     * Display the warning message.
     */
    default void displayWarning(Object message) {
        System.out.println("[WARNING] " + message);
    }

    /**
     * Display message to the user.
     *
     * @param input is a text to display
     */
    void display(String input);

    /**
     * Display message to the user.
     *
     * @param input is a text to display
     */
    void display(Object input);

    /**
     * Display message to the user.
     *
     * @param message is a text to display
     * @param args    extra parameters in a text
     */
    void display(String message, Object... args);

    /**
     * Get input from the user.
     */
    String read();

    /**
     * Get the number from the user.
     */
    int readNumber();

    /**
     * Get language from the user.
     */
    void getLanguage();

    /**
     * Get the sign from the user.
     */
    Sign getSign();
}
