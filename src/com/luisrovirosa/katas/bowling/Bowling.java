package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final GameParser gameParser;

    public Bowling(RollParser parser, GameParser gameParser) {
        this.rollParser = parser;
        this.gameParser = gameParser;
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        Line line = gameParser.parse(rolls);
        GameScorer scorer = new GameScorer(line);

        return scorer.score();
    }

}
