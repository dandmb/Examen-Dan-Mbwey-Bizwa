package kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultTest {

    @Test
    public void the37CorrespondsTo00() {
        Result new_result = new Result(37);
        assertThat(new_result.number).isEqualTo("00");
    }

    @Test()
    public void theResultIsAlwaysBetween00and36() throws Exception {
        assertNumberResult(0, "0");
        assertNumberResult(5, "5");
        assertNumberResult(6, "6");
        assertNumberResult(37, "37");
    }

    @Test
    public void theColorOf0and00IsGreen() throws Exception {
        assertColorResult(0, Result.Color.GREEN);
        assertColorResult(37, Result.Color.GREEN);
    }

    @Test
    public void theColorOfEvenNumbersIsBlack() throws Exception {
        assertColorResult(2, Result.Color.BLACK);
        assertColorResult(14, Result.Color.BLACK);
        assertColorResult(36, Result.Color.BLACK);

    }

    @Test
    public void theColorOfOddNumbersIsRed() throws Exception {
        assertColorResult(1, Result.Color.RED);
        assertColorResult(7, Result.Color.RED);
        assertColorResult(35, Result.Color.RED);

    }

    @Test
    public void itThrowsExceptionWhenTheRandomizerIsGreaterThan37()
            throws Exception {
        RouletteException exception = assertThrows(
                RouletteException.class,
                () -> new Result(38)
        );
        assertEquals("Result can't be 38", exception.getMessage());
    }

    @Test
    public void itThrowsExceptionWhenTheRandomizerIsLesserThan0()
            throws Exception {
        RouletteException exception = assertThrows(RouletteException.class,
                () -> new Result(-1));
        assertEquals("Result can't be -1", exception.getMessage());

    }

    private void assertColorResult(int randomizerValue, Result.Color expectedColor) {
        Result.Color color = new Result(randomizerValue).color;
        assertThat(color).isEqualTo(expectedColor);


    }

    private void assertNumberResult(int randomizerValue, String expectedNumber) {
        assertThat(new Result(randomizerValue).number).isEqualTo(expectedNumber);
    }
}