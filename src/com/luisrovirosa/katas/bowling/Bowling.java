package com.luisrovirosa.katas.bowling;

public class Bowling {

    private final RollParser parser;

    public Bowling(RollParser parser) {
        this.parser = parser;
    }

    public int scoreOf(String rolls) {
        int[] scores = parser.parse(rolls);
        int result = 0;
        int numberOfRoll = 0;
        for (int turn = 0; turn < 10; turn++) {
            result += turnScore(scores, numberOfRoll);
            numberOfRoll += isStrike(scores, numberOfRoll) ? 1 : 2;
        }
        return result;
    }

    private int turnScore(int[] rolls, int numberOfRoll) {
        return basicScore(rolls, numberOfRoll) + bonusScore(rolls, numberOfRoll);
    }

    private int basicScore(int[] rolls, int numberOfRoll) {
        int result = rolls[numberOfRoll];
        if (!isStrike(rolls, numberOfRoll)) {
            result += rolls[numberOfRoll + 1];
        }
        return result;
    }

    private int bonusScore(int[] rolls, int numberOfRoll) {
        int bonus = 0;
        if (isStrike(rolls, numberOfRoll)) {
            bonus = rolls[numberOfRoll + 1] + rolls[numberOfRoll + 2];
        } else if (isSpare(rolls, numberOfRoll)) {
            bonus = rolls[numberOfRoll + 2];
        }
        return bonus;
    }

    private boolean isStrike(int[] rolls, int numberOfRoll) {
        return 10 == rolls[numberOfRoll];
    }

    private boolean isSpare(int[] rolls, int numberOfRoll) {
        return (rolls[numberOfRoll] + rolls[numberOfRoll + 1] == 10);
    }
}
