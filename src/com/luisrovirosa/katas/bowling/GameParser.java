package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class GameParser {

    private static final int NUMBER_OF_TURNS = 10;

    public Game parse(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = normalTurns(scores);
        Turn bonusTurn = bonusTurn(lastTurn(turns), scores);
        return new Game(turns, bonusTurn);
    }

    private ArrayList<Turn> normalTurns(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            Turn turn = getTurn(numberOfRoll, scores);
            turns.add(turn);
            numberOfRoll += turn.isStrike() ? 1 : 2;
        }
        return turns;
    }

    private Turn bonusTurn(Turn lastTurn, ArrayList<Roll> scores) {
        if (!lastTurn.hasKnockAllThePins()) {
            return noBonus();
        }

        Roll lastRoll = scores.get(scores.size() - 1);
        if (lastTurn.isSpare()) {
            return spareBonus(lastRoll);
        }

        Roll penultimateRoll = scores.get(scores.size() - 2);
        return strikeBonus(lastRoll, penultimateRoll);
    }


    private Turn getTurn(int startingRoll, ArrayList<Roll> scores) {
        Roll firstRoll = scores.get(startingRoll);
        if (firstRoll.numberOfKnockedPins() == 10) {
            return new Strike(firstRoll);
        }
        Roll secondRoll = scores.get(startingRoll + 1);
        if (firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins() == 10) {
            return new Spare(firstRoll, secondRoll);
        }
        return new Turn(firstRoll, secondRoll);
    }

    private Turn lastTurn(ArrayList<Turn> turns) {
        return turns.get(turns.size() - 1);
    }

    private Turn noBonus() {
        return new Turn(new MissRoll());
    }

    private Turn spareBonus(Roll lastRoll) {
        return new Turn(lastRoll);
    }

    private Turn strikeBonus(Roll lastRoll, Roll penultimateRoll) {
        return new Turn(penultimateRoll, lastRoll);
    }
}
