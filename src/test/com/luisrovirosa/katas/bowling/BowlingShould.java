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

    @Test
    public void score_1_when_the_first_roll_throw_one_pin_and_miss_others_rolls(){
        Bowling bowling = new Bowling();

        int score = bowling.scoreOf("1-------------------");

        assertThat(score, is(1));
    }

}
