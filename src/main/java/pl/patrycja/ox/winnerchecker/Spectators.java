package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.ScoreBoard;
import pl.patrycja.ox.ui.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * A class created new spectator.
 *
 * @author Patrycja Hyjek
 */
public class Spectators {

    /**
     * This method adds and returns a list of spectators
     *
     * @param gameSettings is an object with game's settings.
     */
    private GameSettings gameSettings;
    private UI ui;
    private ScoreBoard scoreBoard;

    public Spectators(GameSettings gameSettings, UI ui, ScoreBoard scoreBoard) {
        this.gameSettings = gameSettings;
        this.ui = ui;
        this.scoreBoard = scoreBoard;
    }

    public List<Spectator> create() {
        return new ArrayList<>() {{
            add(new Assessor(gameSettings, ui));
            add(new Judge(gameSettings, ui, scoreBoard));
        }};
    }
}
