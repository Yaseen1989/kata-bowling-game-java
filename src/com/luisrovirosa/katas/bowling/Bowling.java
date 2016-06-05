package com.luisrovirosa.katas.bowling;

public class Bowling {

    private final RollParser parser;

    public Bowling(RollParser parser) {
        this.parser = parser;
    }

    public int scoreOf(String rolls) {
        Game game = new Game(parser.parse(rolls));

        return game.score();
    }

}
