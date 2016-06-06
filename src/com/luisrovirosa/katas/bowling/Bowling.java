package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.frame.Frame;
import com.luisrovirosa.katas.bowling.line.Line;
import com.luisrovirosa.katas.bowling.frame.FrameParser;
import com.luisrovirosa.katas.bowling.line.LineScorer;
import com.luisrovirosa.katas.bowling.roll.Roll;

import java.util.ArrayList;

public class Bowling {

    private final RollParser rollParser;
    private final FrameParser frameParser;

    public Bowling(RollParser parser, FrameParser frameParser) {
        this.rollParser = parser;
        this.frameParser = frameParser;
    }

    public int scoreOf(String rollsAsString) {
        ArrayList<Roll> rolls = rollParser.parse(rollsAsString);
        ArrayList<Frame> frames = frameParser.parse(rolls);
        Line line = new Line(frames);
        LineScorer scorer = new LineScorer(line);

        return scorer.score();
    }

}
