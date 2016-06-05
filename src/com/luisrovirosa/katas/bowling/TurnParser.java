package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class TurnParser {

    public ArrayList<Turn> parse(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfRoll = 0;
        Turn turn = null;
        for (int i = 0; i < 10; i++) {
            turn = getTurn(scores, numberOfRoll);
            turns.add(turn);
            numberOfRoll += turn.isStrike() ? 1 : 2;
        }
        turns.add(bonus(scores, numberOfRoll, turn));
        return turns;
    }

    private Turn bonus(ArrayList<Roll> scores, int numberOfRoll, Turn turn) {
        if (turn.isStrike()){
            return new Turn(scores.get(numberOfRoll), scores.get(numberOfRoll + 1));
        }
        if (turn.isSpare()) {
            return new Turn(scores.get(numberOfRoll));
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
