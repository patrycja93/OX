package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UIFactory;
import pl.patrycja.ox.winnerchecker.Spectator;
import pl.patrycja.ox.winnerchecker.SpectatorsRoom;

import java.util.List;


class Game {

    private boolean ifOpenAutomaticTests;
    private Player firstPlayer = new Player("A", Sign.CROSS);
    private Player secondPlayer = new Player("B", Sign.NAUGHT);
    private GameSettings gameSettings;

    public Game(boolean ifOpenAutomaticTests) {
        this.ifOpenAutomaticTests = ifOpenAutomaticTests;
        this.gameSettings = getGameSettings();
    }

    public void play() {
        showDemoText(ifOpenAutomaticTests);
        gameSettings.setPlayer();
        List<Spectator> spectators = SpectatorsRoom.addSpectators(gameSettings);
        PlayerChanger playerChanger = new PlayerChanger(List.of(firstPlayer, secondPlayer), gameSettings);

        while (!gameSettings.isEndGame()) {
            Match.init(gameSettings, spectators)
                    .addController(playerChanger)
                    .start();
        }
    }

    private void showDemoText(boolean ifOpenAutomaticTests) {
        if(ifOpenAutomaticTests){
            System.out.println("Run project in demo mode. \nAutomatic tests result was saved in catalog: src/main/resources/pl/patrycja/ox/ui/test_out.txt.");
        }
    }

    private GameSettings getGameSettings() {
        return GameSettings.builder()
                .boardSize(3)
                .unbrokenLine(3)
                .ui(ifOpenAutomaticTests ? UIFactory.setFileUI() : UIFactory.setConsoleUI())
                .build();
    }
}
