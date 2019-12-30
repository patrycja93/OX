package pl.patrycja.ox.ui;

/**
 * A class UIFactory return a new object ConsoleUI.
 *
 * @author Patrycja Hyjek
 */

public class UIFactory {
    /**
     * This method is called whenever we want an object ConsoleUI.
     */
    public static UI setUI() {
        return new ConsoleUI();
    }
}
