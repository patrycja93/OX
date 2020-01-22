package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ComputerWithUserTest {

    private UI ui;

    @BeforeMethod
    public void createMock() {
        ui = Mockito.mock(UI.class);
    }

    @Test
    public void createPlayersShouldCreatedTwoPlayersWithDifferentSign() {
        //given
        String name = "A";
        int expectedNumberOfPlayers = 2;
        ComputerWithUser mode = new ComputerWithUser(ui);

        //when
        when(ui.read()).thenReturn(name);
        List<Player> players = mode.createPlayers();

        //then
        assertNotEquals(players.get(0).getSign(), players.get(1).getSign());
        assertEquals(players.size(), expectedNumberOfPlayers);
    }

    @Test
    public void settingsShouldCallLanguage() {
        //given
        ComputerWithUser mode = new ComputerWithUser(ui);
        String[] args = {};

        //when
        mode.settings(args);

        //then
        verify(ui).getLanguage();
    }

    @Test
    public void createPlayersShouldDisplayErrorMessage() {
        //given
        String message = "This feature is under construction ;-)";
        ComputerWithUser mode = new ComputerWithUser(ui);

        //when
        mode.createPlayers();

        //then
        verify(ui).displayError(message);
    }
}