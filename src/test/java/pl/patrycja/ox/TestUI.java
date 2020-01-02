package pl.patrycja.ox;

import pl.patrycja.ox.ui.UI;

public class TestUI implements UI {

    @Override
    public void display(Object input) {
        //empty for tests purposes
    }

    @Override
    public String read() {
        //not being used in tests
        return null;
    }
}
