package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser parser;

    public Bowling(RollParser parser) {
        this.parser = parser;
    }

    public int scoreOf(String rolls) {
        ArrayList<Roll> scores = parser.parse(rolls);
        int result = 0;
        int numberOfRoll = 0;
        for (int turn = 0; turn < 10; turn++) {
            result += turnScore(scores, numberOfRoll);
            numberOfRoll += isStrike(scores, numberOfRoll) ? 1 : 2;
        }
        return result;
    }

    private int turnScore(ArrayList<Roll> rolls, int numberOfRoll) {
        return basicScore(rolls, numberOfRoll) + bonusScore(rolls, numberOfRoll);
    }

    private int basicScore(ArrayList<Roll> rolls, int numberOfRoll) {
        int result = rolls.get(numberOfRoll).score();
        if (!isStrike(rolls, numberOfRoll)) {
            result += rolls.get(numberOfRoll + 1).score();
        }
        return result;
    }

    private int bonusScore(ArrayList<Roll> rolls, int numberOfRoll) {
        int bonus = 0;
        if (isStrike(rolls, numberOfRoll)) {
            bonus = rolls.get(numberOfRoll + 1).score() + rolls.get(numberOfRoll + 2).score();
        } else if (isSpare(rolls, numberOfRoll)) {
            bonus = rolls.get(numberOfRoll + 2).score();
        }
        return bonus;
    }

    private boolean isStrike(ArrayList<Roll> rolls, int numberOfRoll) {
        return 10 == rolls.get(numberOfRoll).score();
    }

    private boolean isSpare(ArrayList<Roll> rolls, int numberOfRoll) {
        return (rolls.get(numberOfRoll).score() + rolls.get(numberOfRoll + 1).score() == 10);
    }
}
