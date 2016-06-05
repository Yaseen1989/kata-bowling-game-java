package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private ArrayList<Roll> scores;
    private final ArrayList<Turn> turns;

    public Game(ArrayList<Roll> scores) {
        this.scores = scores;
        turns = turns(scores);
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

    private ArrayList<Turn> turns(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfTurn = 0;
        for (int i = 0; i < 10; i++) {
            Roll roll = scores.get(numberOfTurn);
            if (roll.score() == 10) {
                turns.add(new Turn(roll));
            } else {
                turns.add(new Turn(roll, scores.get(numberOfTurn + 1)));
                numberOfTurn++;
            }
            numberOfTurn++;
        }
        if (numberOfTurn == scores.size() - 1) {
            turns.add(new Turn(scores.get(numberOfTurn)));
        } else if (numberOfTurn == scores.size() - 2) {
            turns.add(new Turn(scores.get(numberOfTurn), scores.get(numberOfTurn + 1)));
        }
        return turns;
    }
}
