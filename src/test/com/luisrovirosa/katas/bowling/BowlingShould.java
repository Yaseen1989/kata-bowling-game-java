package test.com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.Bowling;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingShould {

    @Test
    public void score_0_when_failing_all_the_rolls() {
        assertThat(scoreOf("--------------------"), is(0));
    }

    @Test
    public void score_1_when_the_first_roll_throw_one_pin_and_miss_others_rolls(){
        assertThat(scoreOf("1-------------------"), is(1));
    }

    private int scoreOf(String rolls) {
        Bowling bowling = new Bowling();
        return bowling.scoreOf(rolls);
    }

}
