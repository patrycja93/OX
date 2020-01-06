package pl.patrycja.ox.ui;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A class UIFactory return a new object UI.
 *
 * @author Patrycja Hyjek
 */
public class UIFactory {

    private static final int ZER0_PARAMETERS = 0;
    private static final int ONE_PARAMETERS = 1;
    private static final int TWO_PARAMETERS = 2;
    private static final int THREE_PARAMETERS = 3;

    private final Function<String[], UI> console = ConsoleUI::new;
    private final Function<String[], UI> file = FileUI::new;

    private final Map<Integer, Function<String[], UI>> kindsOfUI = Map.of(
            ZER0_PARAMETERS, console,
            ONE_PARAMETERS, console,
            TWO_PARAMETERS, console,
            THREE_PARAMETERS, file
    );

    public UI getUIForMode(int amountOfParameters, String[] args) {
        return kindsOfUI.get(amountOfParameters).apply(args);
    }
}
