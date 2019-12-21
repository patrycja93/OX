package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;

import java.util.ArrayList;
import java.util.List;

public class SpectatorsRoom {

    public static List<Spectator> addSpectators(GameSettings gameSettings) {
        return new ArrayList<>() {{
            add(new Judge(gameSettings));
        }};
    }
}
