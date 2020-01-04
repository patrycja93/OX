package pl.patrycja.ox.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * A class UIFactory return a new object UI.
 *
 * @author Patrycja Hyjek
 */
public class UIFactory {

    private Map<Integer, UI> kindsOfUi;

    public UIFactory() {
        this.kindsOfUi = setUi();
    }

    public UI getUiFor(int inputArraySize) {
        UI ui = kindsOfUi.get(inputArraySize);
        return ui;
    }

    private Map<Integer, UI> setUi() {
        Map<Integer, UI> map = new HashMap<>();
        map.put(0, new ConsoleUI());
        map.put(1, new ConsoleUI());
        map.put(2, new ConsoleUI());
        map.put(3, new FileUI());
        return map;
    }
}
