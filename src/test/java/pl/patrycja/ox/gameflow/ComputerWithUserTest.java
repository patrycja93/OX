package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class ComputerWithUserTest {

    UI ui = Mockito.mock(UI.class);

    @Test
    public void createPlayersShouldCreatedTwoPlayersWithDifferentSign() {
        //given
        Mode mode = new Game(ui);
        String name = "A";
        Sign signO = Sign.O;

        //when
        List<Player> players = mode.createPlayers();
        when(ui.read()).thenReturn(name);

        //then
        assertNotEquals(players.get(0).getSign(), players.get(1).getSign());
        assertEquals(players.size(), 2);
    }

    @Test
    public void createPlayersShouldShowError() {
        //given
        Mode mode = new ComputerWithUser(ui);
        String message = "This feature is under construction ;-)";

        //when
        mode.createPlayers();

        //then
        verify(ui).displayError(message);
    }

    @Test
    public void settings() {
        //given
        Mode mode = new ComputerWithUser(ui);
        String[] args = {};

        //when
        mode.settings(args);

        //then
        verify(ui).getLanguage();
    }
}