package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Turn> turns;

    public Game(ArrayList<Turn> turns) {
        this.turns = turns;
    }

    public int score() {
        int result = 0;
        for (int numberOfTurn = 0; numberOfTurn < 10; numberOfTurn++) {
            Turn turn = turns.get(numberOfTurn);
            result += turnScore(turn);
        }
        return result;

    }

    private int turnScore(Turn turn) {
        return turn.basicScore() + bonusScore(turn);
    }

    private int bonusScore(Turn turn) {
        if (turn.basicScore() < 10) {
            return 0;
        }

        Turn next = next(turn);
        if (turn.isSpare()) {
            return next.firstRoll().score();
        }

        if (next.isStrike()) {
            return next.basicScore() + next(next).firstRoll().score();
        } else {
            return next.basicScore();
        }
    }

    private Turn next(Turn turn) {
        int numberOfTurn = turns.indexOf(turn);
        return turns.get(numberOfTurn + 1);
    }

}
