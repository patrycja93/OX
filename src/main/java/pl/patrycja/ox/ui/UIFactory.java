package pl.patrycja.ox.ui;

/**
 * A class UIFactory return a new object UI.
 *
 * @author Patrycja Hyjek
 */
public class UIFactory {

    public static UI set(boolean demo) {
        return demo ? new FileUI() : new ConsoleUI();
    }
}
