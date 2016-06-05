package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private ArrayList<Roll> scores;

    public Game(ArrayList<Roll> scores) {
        this.scores = scores;
    }

    public int score() {
        int result = 0;
        int numberOfRoll = 0;
        for (int turn = 0; turn < 10; turn++) {
            result += turnScore(numberOfRoll);
            numberOfRoll += isStrike(numberOfRoll) ? 1 : 2;
        }
        return result;

    }

    private int turnScore(int numberOfRoll) {
        return basicScore(numberOfRoll) + bonusScore(numberOfRoll);
    }

    private int basicScore(int numberOfRoll) {
        int result = scores.get(numberOfRoll).score();
        if (!isStrike(numberOfRoll)) {
            result += scores.get(numberOfRoll + 1).score();
        }
        return result;
    }

    private int bonusScore(int numberOfRoll) {
        int bonus = 0;
        if (isStrike(numberOfRoll)) {
            bonus = scores.get(numberOfRoll + 1).score() + scores.get(numberOfRoll + 2).score();
        } else if (isSpare(numberOfRoll)) {
            bonus = scores.get(numberOfRoll + 2).score();
        }
        return bonus;
    }

    private boolean isStrike(int numberOfRoll) {
        return 10 == scores.get(numberOfRoll).score();
    }

    private boolean isSpare(int numberOfRoll) {
        return (scores.get(numberOfRoll).score() + scores.get(numberOfRoll + 1).score() == 10);
    }
}
