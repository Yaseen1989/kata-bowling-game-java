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
        String score = rolls.substring(numberOfRoll, numberOfRoll + 1);
        if (score.equals("-")) {
            score = "0";
        } else if (score.equals("/")) {
            score = String.valueOf(10 - scoreOf(rolls, numberOfRoll - 1));
        } else if (score.equals("X")) {
            score = "10";
        }
        return Integer.parseInt(score);
    }
}
