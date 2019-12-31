package pl.patrycja.ox.ui;

/**
 * A class UIFactory return a new object UI.
 *
 * @author Patrycja Hyjek
 */
public class UIFactory {
    /**
     * This method is called whenever we want to set UI.
     */
    public static UI setUI() {
        return new ConsoleUI();
    }
}
