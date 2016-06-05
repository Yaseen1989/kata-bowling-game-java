package com.luisrovirosa.katas.bowling;

import java.util.ArrayList;

public class Bowling {

    private final RollParser parser;

    public Bowling(RollParser parser) {
        this.parser = parser;
    }

    public int scoreOf(String rolls) {
        ArrayList<Roll> scores = parser.parse(rolls);
        Game game = new Game(scores);
        return game.score();
    }

}
