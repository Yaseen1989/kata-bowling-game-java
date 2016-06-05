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
        int bonus = 0;
        if (turn.isStrike()) {
            Turn next = next(turn);
            if (next.isStrike()) {
                bonus = next.basicScore() + next(next).firstRoll().score();
            } else {
                bonus = next.basicScore();
            }
        } else if (turn.isSpare()) {
            bonus = next(turn).firstRoll().score();
        }
        return bonus;
    }

    private Turn next(Turn turn) {
        int numberOfTurn = turns.indexOf(turn);
        return turns.get(numberOfTurn + 1);
    }

}
