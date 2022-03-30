package kata;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class BallTest {

    @Test
    public void itRollsForAGivenAmountOfTime() throws Exception {
        int nMilli = 50;
        Ball new_ball = new Ball(nMilli);
        new_ball.roll();
        double before = System.currentTimeMillis();

        double after = System.currentTimeMillis();

        assertThat(after - before).isCloseTo(70, within(30d));

    }
}
