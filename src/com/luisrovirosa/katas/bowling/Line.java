package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;
import java.util.Collection;

public class Line {
    private ArrayList<Turn> turns;
    private Turn bonusTurn;

    public Line(ArrayList<Turn> turns, Turn bonusTurn) {
        this.turns = turns;
        this.bonusTurn = bonusTurn;
    }

    public Collection<Turn> turns() {
        return turns;
    }

    public Turn next(Turn turn) {
        int numberOfTurn = turns.indexOf(turn);
        boolean isLastTurn = numberOfTurn + 1 == turns.size();
        return !isLastTurn ? turns.get(numberOfTurn + 1) : bonusTurn;
    }
}
