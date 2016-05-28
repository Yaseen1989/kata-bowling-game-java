package test.com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.Bowling;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingShould {

    @Test
    public void score_0_when_failing_all_the_rolls() {
        Bowling bowling = new Bowling();

        int score = bowling.scoreOf("--------------------");

        assertThat(score, is(0));
    }

}
