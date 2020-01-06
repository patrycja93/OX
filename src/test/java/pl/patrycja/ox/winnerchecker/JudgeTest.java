package pl.patrycja.ox.winnerchecker;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.patrycja.ox.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JudgeTest {

    @DataProvider
    public Object[][] boardContainHorizontalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(5, new Player("A", Sign.X));
                    put(3, new Player("A", Sign.O));
                    put(4, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(4, new Player("A", Sign.X));
                    put(9, new Player("A", Sign.O));
                    put(5, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(4, new Player("A", Sign.X));
                    put(9, new Player("A", Sign.O));
                    put(5, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(5, new Player("A", Sign.X));
                    put(2, new Player("A", Sign.O));
                    put(4, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {4,
                new HashMap<>() {{
                    put(5, new Player("A", Sign.X));
                    put(10, new Player("A", Sign.O));
                    put(9, new Player("A", Sign.X));
                    put(4, new Player("A", Sign.O));
                    put(7, new Player("A", Sign.X));
                    put(11, new Player("A", Sign.O));
                }}}
        };
    }

    @DataProvider
    public Object[][] boardContainVerticalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(3, new Player("A", Sign.X));
                    put(8, new Player("A", Sign.O));
                    put(9, new Player("A", Sign.X));
                    put(2, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(3, new Player("A", Sign.X));
                    put(5, new Player("A", Sign.O));
                    put(9, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(9, new Player("A", Sign.X));
                    put(8, new Player("A", Sign.O));
                    put(3, new Player("A", Sign.X));
                    put(5, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(9, new Player("A", Sign.X));
                    put(2, new Player("A", Sign.O));
                    put(3, new Player("A", Sign.X));
                    put(7, new Player("A", Sign.O));
                }}}, {4,
                new HashMap<>() {{
                    put(2, new Player("A", Sign.X));
                    put(9, new Player("A", Sign.O));
                    put(10, new Player("A", Sign.X));
                    put(16, new Player("A", Sign.O));
                    put(14, new Player("A", Sign.X));
                    put(8, new Player("A", Sign.O));
                }}}
        };
    }

    @DataProvider
    public Object[][] boardNotContainUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(1, new Player("A", Sign.X));
                    put(5, new Player("A", Sign.O));
                }}}, {3,
                new HashMap<>() {{
                    put(4, new Player("A", Sign.X));
                    put(8, new Player("A", Sign.X));
                }}}, {3,
                new HashMap<>() {{
                    put(1, new Player("A", Sign.X));
                    put(8, new Player("A", Sign.X));
                }}}, {3,
                new HashMap<>() {{
                    put(1, new Player("A", Sign.O));
                    put(9, new Player("A", Sign.X));
                }}}, {4,
                new HashMap<>() {{
                    put(1, new Player("A", Sign.O));
                    put(6, new Player("A", Sign.X));
                    put(11, new Player("A", Sign.O));
                    put(9, new Player("A", Sign.O));
                    put(8, new Player("A", Sign.X));
                    put(14, new Player("A", Sign.X));
                }}}
        };
    }

    @Test(dataProvider = "boardContainHorizontalUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnTrue(int size, Map<Integer, Player> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);
        ScoreBoard scoreBoard = new ScoreBoard(getPlayers());
        Judge judge = new Judge(gameSettings, new TestUI(), scoreBoard);

        //when
        fields.forEach(judge::signWasPut);
        judge.signWasPut(6, new Player("A", Sign.X));
        boolean existsUnbrokenHorizontalLine = judge.isMatchOver();

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnFalse(int size, Map<Integer, Player> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI(), new ScoreBoard(getPlayers()));

        //when
        fields.forEach(judge::signWasPut);
        judge.signWasPut(3, new Player("A", Sign.X));
        boolean existsUnbrokenHorizontalLine = judge.isMatchOver();

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test(dataProvider = "boardContainVerticalUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnTrue(int size, Map<Integer, Player> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI(), new ScoreBoard(getPlayers()));

        //when
        fields.forEach(judge::signWasPut);
        judge.signWasPut(6, new Player("A", Sign.X));
        boolean existsUnbrokenVerticalLine = judge.isMatchOver();

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnFalse(int size, Map<Integer, Player> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI(), new ScoreBoard(getPlayers()));

        //when
        fields.forEach(judge::signWasPut);
        judge.signWasPut(3, new Player("A", Sign.X));
        boolean existsUnbrokenVerticalLine = judge.isMatchOver();

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }

    private GameSettings createGameSettings(int size) {
        return GameSettings.builder()
                .unbrokenLine(3)
                .matchesNumber(3)
                .boardSize(size)
                .build();
    }

    private List<Player> getPlayers() {
        return List.of(new Player("A", Sign.X), new Player("B", Sign.O));
    }
}