package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RouletteAT {

    public Between0And37Randomizer new_randomizer = mock(Between0And37Randomizer.class);
    public Ball new_ball = mock(Ball.class);
    @Test
    public void itWaitsForTheBallToStop() {
        Roulette roulette = new Roulette(new_ball, new_randomizer);

        roulette.playGame();

        verify(new_ball).roll();
    }

    @Test()
    public void itProvidesAResultWithColor() throws Exception {
        Between0And37Randomizer Nrandom = mock(Between0And37Randomizer.class);
        when(Nrandom.getRouletteResult()).thenReturn(0);
        Roulette roulette = new Roulette(new_ball, Nrandom);

        Result actualResult = roulette.playGame();

        assertEquals("0", actualResult.number);

        assertEquals(Result.Color.GREEN, actualResult.color);
    }

}
