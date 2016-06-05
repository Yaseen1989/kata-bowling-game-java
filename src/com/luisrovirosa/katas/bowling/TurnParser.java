package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class TurnParser {

    public ArrayList<Turn> parse(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = normalTurns(scores);
        turns.add(bonusTurn(scores, turns));
        return turns;
    }

    private ArrayList<Turn> normalTurns(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < 10; i++) {
            Turn turn = getTurn(scores, numberOfRoll);
            turns.add(turn);
            numberOfRoll += turn.isStrike() ? 1 : 2;
        }
        return turns;
    }

    private Turn bonusTurn(ArrayList<Roll> scores, ArrayList<Turn> turns) {
        Turn lastTurn = turns.get(turns.size() - 1);
        if (lastTurn.isStrike()){
            return new Turn(scores.get(scores.size()-2), scores.get(scores.size()-1));
        }
        if (lastTurn.isSpare()) {
            return new Turn(scores.get(scores.size()-1));
        }
        return new Turn(new Roll(0));
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
