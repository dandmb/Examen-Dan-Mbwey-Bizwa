package kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaRandomizerIT {

    public JavaRandomizer jvrandom=new JavaRandomizer();
    @Test
    public void numbersAreNeverOutsideBoundsOf0And37() throws Exception {

        IntStream generateResult=IntStream.range(0, 10000).map(i -> jvrandom.getRouletteResult());
        assertThat(generateResult.min().getAsInt()).isEqualTo(0);
        assertThat(generateResult.max().getAsInt()).isEqualTo(37);

    }

    @Test
    public void allNumbersOccur() throws Exception {
        IntStream generateResult=IntStream.range(0, 10000).map(i -> jvrandom.getRouletteResult());

        IntStream uniqueResults = generateResult.distinct();
        assertThat(uniqueResults).size().isEqualTo(38);

    }


}
