package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.frame.Frame;
import com.luisrovirosa.katas.bowling.line.Line;
import com.luisrovirosa.katas.bowling.frame.FrameParser;
import com.luisrovirosa.katas.bowling.line.LineScorer;
import com.luisrovirosa.katas.bowling.roll.Roll;
import com.luisrovirosa.katas.bowling.roll.RollParser;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final FrameParser frameParser;

    public Bowling(RollParser parser) {
        this.rollParser = parser;
        this.frameParser = new FrameParser();
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        ArrayList<Frame> frames = frameParser.parse(rolls);
        LineScorer scorer = new LineScorer(new Line(frames));

        return scorer.score();
    }

}
