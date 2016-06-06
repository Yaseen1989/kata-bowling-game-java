package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final LineParser lineParser;

    public Bowling(RollParser parser, LineParser lineParser) {
        this.rollParser = parser;
        this.lineParser = lineParser;
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        Line line = lineParser.parse(rolls);
        LineScorer scorer = new LineScorer(line);

        return scorer.score();
    }

}
