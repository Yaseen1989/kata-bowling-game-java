package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final GameParser turnParser;

    public Bowling(RollParser parser, GameParser turnParser) {
        this.rollParser = parser;
        this.turnParser = turnParser;
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        Game game = turnParser.parse(rolls);
        GameScorer scorer = new GameScorer(game);

        return scorer.score();
    }

}
