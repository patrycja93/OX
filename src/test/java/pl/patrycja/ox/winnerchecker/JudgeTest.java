package pl.patrycja.ox.winnerchecker;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.patrycja.ox.GameSettings;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.TestUI;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JudgeTest {

    @DataProvider
    public Object[][] boardContainHorizontalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(4, Sign.X);
                    put(2, Sign.O);
                    put(3, Sign.X);
                    put(6, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(3, Sign.X);
                    put(8, Sign.O);
                    put(4, Sign.X);
                    put(6, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(3, Sign.X);
                    put(8, Sign.O);
                    put(4, Sign.X);
                    put(6, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(4, Sign.X);
                    put(1, Sign.O);
                    put(3, Sign.X);
                    put(6, Sign.O);
                }}}, {4,
                new HashMap<>() {{
                    put(4, Sign.X);
                    put(9, Sign.O);
                    put(7, Sign.X);
                    put(3, Sign.O);
                    put(6, Sign.X);
                    put(10, Sign.O);
                }}}
        };
    }

    @DataProvider
    public Object[][] boardContainVerticalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(2, Sign.X);
                    put(7, Sign.O);
                    put(8, Sign.X);
                    put(1, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(2, Sign.X);
                    put(4, Sign.O);
                    put(8, Sign.X);
                    put(6, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(8, Sign.X);
                    put(7, Sign.O);
                    put(2, Sign.X);
                    put(4, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(8, Sign.X);
                    put(1, Sign.O);
                    put(2, Sign.X);
                    put(6, Sign.O);
                }}}, {4,
                new HashMap<>() {{
                    put(1, Sign.X);
                    put(8, Sign.O);
                    put(9, Sign.X);
                    put(15, Sign.O);
                    put(13, Sign.X);
                    put(7, Sign.O);
                }}}
        };
    }

    @DataProvider
    public Object[][] boardNotContainUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(0, Sign.X);
                    put(4, Sign.O);
                }}}, {3,
                new HashMap<>() {{
                    put(3, Sign.X);
                    put(7, Sign.X);
                }}}, {3,
                new HashMap<>() {{
                    put(0, Sign.X);
                    put(7, Sign.X);
                }}}, {3,
                new HashMap<>() {{
                    put(0, Sign.O);
                    put(8, Sign.X);
                }}}, {4,
                new HashMap<>() {{
                    put(0, Sign.O);
                    put(5, Sign.X);
                    put(10, Sign.O);
                    put(8, Sign.O);
                    put(7, Sign.X);
                    put(13, Sign.X);
                }}}
        };
    }

    @Test(dataProvider = "boardContainHorizontalUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);
        Judge judge = new Judge(gameSettings, new TestUI());

        //when
        fields.forEach(judge::putSignSuccess);
        judge.putSignSuccess(5, Sign.X);
        boolean existsUnbrokenHorizontalLine = judge.isMatchOver();

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI());

        //when
        fields.forEach(judge::putSignSuccess);
        judge.putSignSuccess(2, Sign.X);
        boolean existsUnbrokenHorizontalLine = judge.isMatchOver();

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test(dataProvider = "boardContainVerticalUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI());

        //when
        fields.forEach(judge::putSignSuccess);
        judge.putSignSuccess(5, Sign.X);
        boolean existsUnbrokenVerticalLine = judge.isMatchOver();

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        GameSettings gameSettings = createGameSettings(size);

        Judge judge = new Judge(gameSettings, new TestUI());

        //when
        fields.forEach(judge::putSignSuccess);
        judge.putSignSuccess(2, Sign.X);
        boolean existsUnbrokenVerticalLine = judge.isMatchOver();

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }

    private GameSettings createGameSettings(int size) {
        return GameSettings.builder()
                .unbrokenLine(3)
                .matchesNumber(3)
                .boardSize(size)
                .ui(new TestUI())
                .build();
    }
}