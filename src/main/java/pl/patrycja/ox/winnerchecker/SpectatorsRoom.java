package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class SpectatorsRoom {

    public static List<Spectators> addSpectators(GameSettings gameSettings) {
        return new ArrayList<>() {{
            add(new Judge(new ConsoleUI(), gameSettings));
        }};
    }
}
