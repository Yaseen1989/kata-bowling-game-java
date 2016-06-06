package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.frame.Frame;

public class LineScorer {
    private Line line;

    public LineScorer(Line line) {
        this.line = line;
    }

    public int score() {
        int result = 0;
        for (Frame frame : line.turns()) {
            result += turnScore(frame);
        }
        return result;

    }

    private int turnScore(Frame frame) {
        return frame.numberOfKnockedPins() + bonusScore(frame);
    }

    private int bonusScore(Frame frame) {
        if (frame.isSpare()) {
            return spareBonus(frame);
        }

        if (frame.isStrike()) {
            return strikeBonus(frame);
        }

        return 0;
    }

    private int spareBonus(Frame frame) {
        Frame nextFrame = line.next(frame);
        return nextFrame.numberOfPinsKnockedInFirstRoll();
    }

    private int strikeBonus(Frame frame) {
        Frame nextFrame = line.next(frame);
        if (nextFrame.isStrike()) {
            return nextFrame.numberOfPinsKnockedInFirstRoll() + line.next(nextFrame).numberOfPinsKnockedInFirstRoll();
        }
        return nextFrame.numberOfKnockedPins();
    }

}
