package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private ArrayList<Roll> scores;
    private final ArrayList<Turn> turns = new ArrayList<>();

    public Game(ArrayList<Roll> scores) {
        this.scores = scores;
        initializeTurns(scores);
    }

    public int score() {
        int result = 0;
        int numberOfRoll = 0;
        for (int numberOfTurn = 0; numberOfTurn < 10; numberOfTurn++) {
            Turn turn = turns.get(numberOfTurn);
            result += turnScore(turn, numberOfRoll);
            numberOfRoll += isStrike(turn, numberOfRoll) ? 1 : 2;
        }
        return result;

    }

    private int turnScore(Turn turn, int numberOfRoll) {
        return turn.basicScore() + bonusScore(turn, numberOfRoll);
    }

    private int bonusScore(Turn turn, int numberOfRoll) {
        int bonus = 0;
        if (isStrike(turn, numberOfRoll)) {
            bonus = scores.get(numberOfRoll + 1).score() + scores.get(numberOfRoll + 2).score();
        } else if (isSpare(numberOfRoll)) {
            bonus = scores.get(numberOfRoll + 2).score();
        }
        return bonus;
    }

    private boolean isStrike(Turn turn, int numberOfRoll) {
        return 10 == scores.get(numberOfRoll).score();
    }

    private boolean isSpare(int numberOfRoll) {
        return (scores.get(numberOfRoll).score() + scores.get(numberOfRoll + 1).score() == 10);
    }

    private void initializeTurns(ArrayList<Roll> scores) {
        int numberOfRoll = 0;
        for (int i = 0; i < 10; i++) {
            Roll roll = scores.get(numberOfRoll);
            if (roll.score() == 10) {
                turns.add(new Strike(roll));
            } else if (roll.score() + scores.get(numberOfRoll+1).score() == 10) {
                turns.add(new Spare(roll, scores.get(numberOfRoll + 1)));
                numberOfRoll++;
            }else {
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
