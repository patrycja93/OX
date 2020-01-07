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

    private final UI ui = Mockito.mock(UI.class);

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
}