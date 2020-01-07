package pl.patrycja.ox.gameflow;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ModeFactoryTest {

    private final String boardSize = "5";
    private final String unbrokenLine = "4";
    private final String towardsDiagonalUp = "2";
    private final String[] argsWithZeroParameters = {};
    private final String[] argsWithTwoParameters = {boardSize, unbrokenLine};
    private final String[] argsWithThreeParameters = {boardSize, unbrokenLine, towardsDiagonalUp};

    @Test
    public void setModeCreateGameMode() {
        //given
        ModeFactory modeFactory = new ModeFactory(argsWithTwoParameters);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof Game);
    }

    @Test
    public void setModeCreateComputerWithUserMode() {
        //given
        ModeFactory modeFactory = new ModeFactory(argsWithZeroParameters);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof ComputerWithUser);
    }

    @Test
    public void setModeCreateAutomaticTestsMode() {
        //given
        ModeFactory modeFactory = new ModeFactory(argsWithThreeParameters);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof AutomaticTests);
    }
}