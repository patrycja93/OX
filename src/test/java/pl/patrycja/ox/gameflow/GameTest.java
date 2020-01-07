package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class GameTest {

    private final UI ui = Mockito.mock(UI.class);
    private final String boardSize = "5";
    private final String unbrokenLine = "4";
    private final String[] args = {boardSize, unbrokenLine};
    private final String[] argsWithOneParameter = {boardSize};
    private final Game game = new Game(ui);
    private final Sign signO = Sign.O;
    private final Sign signX = Sign.X;
    private final String name = "A";

    @Test
    public void settingsShouldSetBoardSizeToFive() {
        //given
        int expectedBoardSize = 5;

        //when
        game.settings(args);

        //then
        assertEquals(game.gameSettings.getBoardSize(), expectedBoardSize);
    }

    @Test
    public void settingsShouldSetUnbrokenLineToFour() {
        //given
        int expectedUnbrokenLine = 4;

        //when
        game.settings(args);

        //then
        assertEquals(game.gameSettings.getUnbrokenLine(), expectedUnbrokenLine);
    }

    @Test
    public void settingsShouldSetNumberOfMatches() {
        //given
        int expectedNumberOfMatches = 3;

        //when
        game.settings(args);

        //then
        assertEquals(game.gameSettings.getNumberOfMatches(), expectedNumberOfMatches);
    }

    @Test
    public void settingsShouldSetNumberOfUnbrokenLineToThree() {
        //given
        int expectedNumberOfMatches = 3;

        //when
        game.settings(argsWithOneParameter);

        //then
        assertEquals(game.gameSettings.getNumberOfMatches(), expectedNumberOfMatches);
    }

    @Test
    public void createPlayersShouldCreatedTwoPlayersWithDifferentSign() {
        //given
        int expectedNumberOfPlayers = 2;

        //when
        List<Player> players = game.createPlayers();
        when(ui.read()).thenReturn(name);

        //then
        assertEquals(players.get(0).getSign(), signX);
        assertEquals(players.get(1).getSign(), signO);
        assertEquals(players.size(), expectedNumberOfPlayers);
    }

    @Test
    public void createPlayersShouldReturnListOfPlayersEqualsTwo() {
        //given
        int expectedNumberOfPlayers = 2;

        //when
        List<Player> players = game.createPlayers();
        when(ui.read()).thenReturn(name);

        //then
        assertEquals(players.size(), expectedNumberOfPlayers);
    }
}