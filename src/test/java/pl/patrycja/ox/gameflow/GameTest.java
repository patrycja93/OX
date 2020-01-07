package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class GameTest {

    UI ui = Mockito.mock(UI.class);

    @Test
    public void settingsShouldSetBoardSizeToFive() {
        //given
        String[] args = {"5", "4"};
        Mode mode = new Game(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getBoardSize(), 5);
    }

    @Test
    public void settingsShouldSetUnbrokenLineToFour() {
        //given
        String[] args = {"5", "4"};
        Mode mode = new Game(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getUnbrokenLine(), 4);
    }

    @Test
    public void settingsShouldSetNumberOfMatches() {
        //given
        String[] args = {"5", "4"};
        Mode mode = new Game(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), 3);
    }

    @Test
    public void settingsShouldSetNumberOfUnbrokenLineToThree() {
        //given
        String[] args = {"5"};
        Mode mode = new Game(ui);

        //when
        mode.settings(args);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), 3);
    }

    @Test
    public void createPlayersShouldCreatedTwoPlayersWithDifferentSign() {
        //given
        Mode mode = new Game(ui);
        String name = "A";
        Sign signO = Sign.O;
        Sign signX = Sign.X;

        //when
        List<Player> players = mode.createPlayers();
        when(ui.read()).thenReturn(name);

        //then
        assertEquals(players.get(0).getSign(), signX);
        assertEquals(players.get(1).getSign(), signO);
        assertEquals(players.size(), 2);
    }

    @Test
    public void createPlayersShouldReturnListOfPlayersEqualsTwo() {
        //given
        Mode mode = new Game(ui);
        String name = "A";

        //when
        List<Player> players = mode.createPlayers();
        when(ui.read()).thenReturn(name);

        //then
        assertEquals(players.size(), 2);
    }

}