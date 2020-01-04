package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.ui.UI;
import pl.patrycja.ox.ui.UIFactory;

class FactoryMode {

    private int inputParametersSize;

    FactoryMode(int inputParametersSize) {
        this.inputParametersSize = inputParametersSize;
    }

    //create game settings object and set board size
    //unbroken line, ui taking amount of args
    Mode setMode() {
        switch (inputParametersSize) {
            case 0: {
                return new ComputerWithUser(getUi(inputParametersSize));
            }
            case 1:
            case 2: {
                return new Game(getUi(inputParametersSize));
            }
            default: {
                return new AutomaticTests(getUi(inputParametersSize));
            }
        }
    }

    private UI getUi(int inputParametersSize) {
        UIFactory uiFactory = new UIFactory();
        return uiFactory.getUiFor(inputParametersSize);
    }
}
