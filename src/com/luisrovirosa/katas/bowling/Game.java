package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Turn> turns = new ArrayList<>();

    public Game(ArrayList<Roll> scores) {
        initializeTurns(scores);
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

    private void initializeTurns(ArrayList<Roll> scores) {
        int numberOfRoll = 0;
        for (int i = 0; i < 10; i++) {
            Roll roll = scores.get(numberOfRoll);
            if (roll.score() == 10) {
                turns.add(new Strike(roll));
            } else if (roll.score() + scores.get(numberOfRoll + 1).score() == 10) {
                turns.add(new Spare(roll, scores.get(numberOfRoll + 1)));
                numberOfRoll++;
            } else {
                turns.add(new Turn(roll, scores.get(numberOfRoll + 1)));
                numberOfRoll++;
            }
            numberOfRoll++;
        }
        if (numberOfRoll == scores.size() - 1) {
            turns.add(new Turn(scores.get(numberOfRoll)));
        } else if (numberOfRoll == scores.size() - 2) {
            turns.add(new Turn(scores.get(numberOfRoll), scores.get(numberOfRoll + 1)));
        }
    }
}
