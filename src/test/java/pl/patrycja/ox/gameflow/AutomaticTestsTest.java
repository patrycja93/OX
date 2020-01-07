package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AutomaticTestsTest {


    private UI ui;
    private final String boardSize = "5";
    private final String unbrokenLine = "4";
    private final String towardsHorizontal = "0";
    private final String towardsDiagonalDown = "3";
    private final String towardsDraw = "4";
    private final String[] inputArrayWithTowardsHorizontal = {boardSize, unbrokenLine, towardsHorizontal};
    private final String[] inputArrayWithTowardDiagonalDown = {boardSize, unbrokenLine, towardsDiagonalDown};
    private final String[] inputArrayWithTowardDraw = {boardSize, unbrokenLine, towardsDraw};

    @BeforeMethod
    public void createMock() {
        ui = Mockito.mock(UI.class);
    }

    @Test
    public void settingsShouldSetBoardSizeToFive() {
        //given
        int expectedBoardSize = 5;
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(inputArrayWithTowardsHorizontal);

        //then
        assertEquals(mode.gameSettings.getBoardSize(), expectedBoardSize);
    }

    @Test
    public void settingsShouldSetUnbrokenLineToFour() {
        //given
        int expectedUnbrokenLineLength = 4;
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(inputArrayWithTowardsHorizontal);

        //then
        assertEquals(mode.gameSettings.getUnbrokenLine(), expectedUnbrokenLineLength);
    }

    @Test
    public void settingsShouldSetNumberOfMatches() {
        //given
        int expectedNumberOfMatchesForHorizontal = 10;
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(inputArrayWithTowardsHorizontal);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), expectedNumberOfMatchesForHorizontal);
    }

    @Test
    public void settingsShouldSetNumberOfMatchesDiagonals() {
        //given
        int expectedNumberOfMatchesForDiagonal = 4;
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(inputArrayWithTowardDiagonalDown);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), expectedNumberOfMatchesForDiagonal);
    }

    @Test
    public void settingsShouldSetNumberOfMatchesDraw() {
        //given
        int expectedNumberOfMatchesForDraw = 1;
        Mode mode = new AutomaticTests(ui);

        //when
        mode.settings(inputArrayWithTowardDraw);

        //then
        assertEquals(mode.gameSettings.getNumberOfMatches(), expectedNumberOfMatchesForDraw);
    }

    @Test
    public void createPlayersShouldReturnListOfPlayersEqualsTwo() {
        //given
        int expectedNumberOfPlayers = 2;
        Mode mode = new AutomaticTests(ui);

        //when
        List<Player> players = mode.createPlayers();

        //then
        assertEquals(players.size(), expectedNumberOfPlayers);
    }
}