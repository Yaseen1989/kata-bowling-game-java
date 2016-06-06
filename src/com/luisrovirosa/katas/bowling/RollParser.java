package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.roll.Roll;

import java.util.ArrayList;

public class RollParser {
    public ArrayList<Roll> parse(String rolls) {
        ArrayList<Roll> result = new ArrayList<>();
        for (int i = 0; i < rolls.length(); i++) {
            result.add(createRoll(rolls, i));
        }
        return result;
    }

    private Roll createRoll(String rolls, int i) {
        int score = scoreOf(i, rolls);
        return new Roll(score);
    }

    private int scoreOf(int numberOfRoll, String rolls) {
        char score = rolls.charAt(numberOfRoll);
        if (score == '-') {
            return 0;
        }
        if (score == '/') {
            return 10 - scoreOf(numberOfRoll - 1, rolls);
        }
        if (score == 'X') {
            return 10;
        }
        return Character.getNumericValue(score);
    }
}
