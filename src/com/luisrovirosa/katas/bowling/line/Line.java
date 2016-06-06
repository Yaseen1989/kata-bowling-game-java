package com.luisrovirosa.katas.bowling.line;

import com.luisrovirosa.katas.bowling.frame.Frame;

import java.util.ArrayList;
import java.util.Collection;

public class Line {
    private ArrayList<Frame> frames;
    private Frame bonusFrame;

    public Line(ArrayList<Frame> frames, Frame bonusFrame) {
        this.frames = frames;
        this.bonusFrame = bonusFrame;
    }

    public Collection<Frame> turns() {
        return frames;
    }

    public Frame next(Frame frame) {
        int numberOfTurn = frames.indexOf(frame);
        boolean isLastTurn = numberOfTurn + 1 == frames.size();
        return !isLastTurn ? frames.get(numberOfTurn + 1) : bonusFrame;
    }
}
