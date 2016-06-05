package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Game {
    private ArrayList<Turn> turns;
    private Turn bonusTurn;

    public Game(ArrayList<Turn> turns, Turn bonusTurn) {
        this.turns = turns;
        this.bonusTurn = bonusTurn;
    }

    public Turn turn(int numberOfTurn) {
        return turns.get(numberOfTurn);
    }

    public Turn next(Turn turn) {
        int numberOfTurn = turns.indexOf(turn);
        boolean isLastTurn = numberOfTurn + 1 == turns.size();
        return !isLastTurn ? turns.get(numberOfTurn + 1) : bonusTurn;
    }
}
