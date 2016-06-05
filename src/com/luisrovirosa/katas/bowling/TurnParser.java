package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class TurnParser {

    public ArrayList<Turn> parse(ArrayList<Roll> scores) {
        ArrayList<Turn> turns = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < 10; i++) {
            Turn turn = getTurn(scores, numberOfRoll);
            turns.add(turn);
            numberOfRoll += turn.isStrike() ? 1 : 2;
        }
        if (numberOfRoll == scores.size() - 1) {
            turns.add(new Turn(scores.get(numberOfRoll)));
        } else if (numberOfRoll == scores.size() - 2) {
            turns.add(new Turn(scores.get(numberOfRoll), scores.get(numberOfRoll + 1)));
        }
        return turns;
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
