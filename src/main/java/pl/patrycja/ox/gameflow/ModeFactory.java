package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

import java.util.Map;
import java.util.function.Function;

class ModeFactory {

    private int inputParametersSize;
    private String[] args;

    private static final int ZER0_PARAMETERS = 0;
    private static final int ONE_PARAMETERS = 1;
    private static final int TWO_PARAMETERS = 2;
    private static final int THREE_PARAMETERS = 3;

    private final Function<Integer, Mode> computerWithPlayer = amountOfParameters -> new ComputerWithUser(getUi(amountOfParameters));
    private final Function<Integer, Mode> game = amountOfParameters -> new Game(getUi(amountOfParameters));
    private final Function<Integer, Mode> automaticTests = amountOfParameters -> new AutomaticTests(getUi(amountOfParameters));

    private final Map<Integer, Function<Integer, Mode>> modesMap = Map.of(
            ZER0_PARAMETERS, computerWithPlayer,
            ONE_PARAMETERS, game,
            TWO_PARAMETERS, game,
            THREE_PARAMETERS, automaticTests
    );

    ModeFactory(int inputParametersSize, String[] args) {
        this.inputParametersSize = inputParametersSize;
        this.args = args;
    }

    Mode setMode() {
        return modesMap.get(inputParametersSize).apply(inputParametersSize);
    }

    private UI getUi(int amountOfParameters) {
        UIFactory uiFactory = new UIFactory();
        return uiFactory.getUIForMode(amountOfParameters, args);
    }
}
