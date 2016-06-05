package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class GameParser {

    private static final int NUMBER_OF_TURNS = 10;

    public Game parse(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = normalTurns(scores);
        Turn bonusTurn = bonusTurn(scores, turns);
        return new Game(turns, bonusTurn);
    }

    private ArrayList<Turn> normalTurns(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            Turn turn = getTurn(scores, numberOfRoll);
            turns.add(turn);
            numberOfRoll += turn.isStrike() ? 1 : 2;
        }
        return turns;
    }

    private Turn bonusTurn(ArrayList<Roll> scores, ArrayList<Turn> turns) {
        Turn lastTurn = lastTurn(turns);
        if (!lastTurn.hasBonus()) {
            return new Turn(new Roll(0));
        }

        Roll lastRoll = scores.get(scores.size() - 1);
        if (lastTurn.isSpare()) {
            return new Turn(lastRoll);
        }

        Roll penultimateRoll = scores.get(scores.size() - 2);
        return new Turn(penultimateRoll, lastRoll);
    }

    private Turn lastTurn(ArrayList<Turn> turns) {
        return turns.get(turns.size() - 1);
    }

    private Turn getTurn(ArrayList<Roll> scores, int numberOfRoll) {
        Roll firstRoll = scores.get(numberOfRoll);
        if (firstRoll.score() == 10) {
            return new Strike(firstRoll);
        }
        Roll secondRoll = scores.get(numberOfRoll + 1);
        if (firstRoll.score() + secondRoll.score() == 10) {
            return new Spare(firstRoll, secondRoll);
        }
        return new Turn(firstRoll, secondRoll);
    }

}
