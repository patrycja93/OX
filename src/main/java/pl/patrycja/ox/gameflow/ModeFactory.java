package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UiFactory;

import java.util.Map;
import java.util.function.Function;

class ModeFactory {

    private static final int MAXIMUM_AMOUNT_OF_PARAMETERS = 3;
    private static final int ZER0_PARAMETERS = 0;
    private static final int ONE_PARAMETERS = 1;
    private static final int TWO_PARAMETERS = 2;
    private static final int THREE_PARAMETERS = 3;
    private static final int NUMBER_OF_PARAMETERS_FOR_AUTOMATIC_TESTS = 4;

    private final Function<Integer, Mode> computerWithPlayer =
            amountOfParameters -> new ComputerWithUser(getUi(amountOfParameters));
    private final Function<Integer, Mode> game =
            amountOfParameters -> new Game(getUi(amountOfParameters));
    private final Function<Integer, Mode> automaticTests =
            amountOfParameters -> new AutomaticTests(getUi(amountOfParameters));

    private String[] args;

    private final Map<Integer, Function<Integer, Mode>> modesMap = Map.of(
            ZER0_PARAMETERS, computerWithPlayer,
            ONE_PARAMETERS, game,
            TWO_PARAMETERS, game,
            THREE_PARAMETERS, automaticTests,
            NUMBER_OF_PARAMETERS_FOR_AUTOMATIC_TESTS, automaticTests
    );

    ModeFactory(String[] args) {
        this.args = args;
    }

    Mode setMode() {
        int atMostMaximum = Math.min(args.length, MAXIMUM_AMOUNT_OF_PARAMETERS);
        return modesMap.get(atMostMaximum)
                .apply(atMostMaximum);
    }

    private UI getUi(int amountOfParameters) {
        UiFactory uiFactory = new UiFactory();
        return uiFactory.getUiForMode(amountOfParameters, args);
    }
}
