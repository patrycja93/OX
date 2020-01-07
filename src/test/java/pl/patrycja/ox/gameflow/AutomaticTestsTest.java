package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AutomaticTestsTest {

    UI ui = Mockito.mock(UI.class);

    @Test
    public void settingsShouldSetBoardSizeToFive() {
        //given
        String[] args = {"5", "4", "0"};
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getBoardSize(), 5);
    }

    @Test
    public void settingsShouldSetUnbrokenLineToFour() {
        //given
        String[] args = {"5", "4", "0"};
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getUnbrokenLine(), 4);
    }

    @Test
    public void settingsShouldSetNumberOfMatches() {
        //given
        String[] args = {"5", "4", "0"};
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), 10);
    }

    @Test
    public void createPlayersShouldReturnListOfPlayersEqualsTwo() {
        //given
        Mode mode = new AutomaticTests(ui);

        //when
        List<Player> players = mode.createPlayers();

        //then
        assertEquals(players.size(), 2);
    }
}