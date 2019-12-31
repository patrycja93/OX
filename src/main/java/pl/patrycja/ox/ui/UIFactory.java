package pl.patrycja.ox.ui;

/**
 * A class UIFactory return a new object UI.
 *
 * @author Patrycja Hyjek
 */
public class UIFactory {
    /**
     * This method is called whenever we want to set UI for ConsoleUI.
     */
    public static UI setConsoleUI() {
        return new ConsoleUI();
    }

    /**
     * This method is called whenever we want to set UI for FileUI.
     */
    public static UI setFileUI() {
        return new FileUI();
    }
}
