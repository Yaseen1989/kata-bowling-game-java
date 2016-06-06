package com.luisrovirosa.katas.bowling.line;

import com.luisrovirosa.katas.bowling.frame.Frame;
import com.luisrovirosa.katas.bowling.frame.Spare;
import com.luisrovirosa.katas.bowling.frame.Strike;
import com.luisrovirosa.katas.bowling.roll.MissRoll;
import com.luisrovirosa.katas.bowling.roll.Roll;

import java.util.ArrayList;

public class LineParser {

    private static final int NUMBER_OF_TURNS = 10;

    public Line parse(ArrayList<Roll> scores) {
        ArrayList<Frame> frames = normalTurns(scores);
        Frame bonusFrame = bonusTurn(lastTurn(frames), scores);
        return new Line(frames, bonusFrame);
    }

    private ArrayList<Frame> normalTurns(ArrayList<Roll> scores) {
        ArrayList<Frame> frames = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            Frame frame = getTurn(numberOfRoll, scores);
            frames.add(frame);
            numberOfRoll += frame.isStrike() ? 1 : 2;
        }
        return frames;
    }

    private Frame bonusTurn(Frame lastFrame, ArrayList<Roll> scores) {
        if (lastFrame.isSpare()) {
            return spareBonus(scores);
        }
        if (lastFrame.isStrike()) {
            return strikeBonus(scores);
        }
        return noBonus();
    }


    private Frame getTurn(int startingRoll, ArrayList<Roll> scores) {
        Roll firstRoll = scores.get(startingRoll);
        if (firstRoll.numberOfKnockedPins() == 10) {
            return new Strike(firstRoll);
        }
        Roll secondRoll = scores.get(startingRoll + 1);
        if (firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins() == 10) {
            return new Spare(firstRoll, secondRoll);
        }
        return new Frame(firstRoll, secondRoll);
    }

    private Frame lastTurn(ArrayList<Frame> frames) {
        return frames.get(frames.size() - 1);
    }

    private Frame noBonus() {
        return new Frame(new MissRoll());
    }

    private Frame spareBonus(ArrayList<Roll> scores) {
        Roll lastRoll = getRollStartingByTheEnd(0, scores);
        return new Frame(lastRoll);
    }

    private Frame strikeBonus(ArrayList<Roll> scores) {
        Roll lastRoll = getRollStartingByTheEnd(0, scores);
        Roll penultimateRoll = getRollStartingByTheEnd(1, scores);

        return new Frame(penultimateRoll, lastRoll);
    }

    private Roll getRollStartingByTheEnd(int positionFromEnd, ArrayList<Roll> scores) {
        int realPosition = scores.size() - (positionFromEnd + 1);
        return scores.get(realPosition);
    }
}
