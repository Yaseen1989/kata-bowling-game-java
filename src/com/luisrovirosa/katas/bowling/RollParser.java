package com.luisrovirosa.katas.bowling;

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
        int score = scoreOf(rolls, i);
        if (score == 0){
            return new MissRoll();
        }
        return new NormalRoll(score);
    }

    private int scoreOf(String rolls, int numberOfRoll) {
        char score = rolls.charAt(numberOfRoll);
        if (score == '-') {
            return 0;
        }
        if (score == '/') {
            return 10 - scoreOf(rolls, numberOfRoll - 1);
        }
        if (score == 'X') {
            return 10;
        }
        return Character.getNumericValue(score);
    }
}
