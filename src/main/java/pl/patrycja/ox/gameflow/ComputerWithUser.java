package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

/**
 * In progress building...
 */

class ComputerWithUser extends Mode {

    ComputerWithUser(UI ui) {
        super(ui);
    }

    @Override
    public List<Player> createPlayers() {
        Player firstPlayer = new Player("Henio", Sign.X);
        ui.display(firstPlayer);
        ui.display("put_second_player_name");
        Player secondPlayer = new Player(ui.read(), Sign.O);
        ui.display(secondPlayer);
        ui.displayError("This feature is under construction ;-)");
        return List.of(firstPlayer, secondPlayer);
    }

    @Override
    public void settings(String[] inputArrayParameters) {
        ui.getLanguage();
    }
}
