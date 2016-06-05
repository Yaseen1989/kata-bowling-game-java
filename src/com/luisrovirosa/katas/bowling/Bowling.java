package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final TurnParser turnParser;

    public Bowling(RollParser parser, TurnParser turnParser) {
        this.rollParser = parser;
        this.turnParser = turnParser;
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        ArrayList<Turn> turns = turnParser.parse(rolls);
        GameScorer scorer = new GameScorer(turns);

        return scorer.score();
    }

}
