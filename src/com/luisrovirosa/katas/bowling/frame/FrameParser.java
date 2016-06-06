package com.luisrovirosa.katas.bowling.frame;

import com.luisrovirosa.katas.bowling.frame.bonus.BonusFrame;
import com.luisrovirosa.katas.bowling.frame.bonus.NoBonusFrame;
import com.luisrovirosa.katas.bowling.roll.Roll;

import java.util.ArrayList;

public class FrameParser {

    private static final int NUMBER_OF_TURNS = 10;

    public ArrayList<Frame> parse(ArrayList<Roll> rolls) {
        ArrayList<Frame> frames = normalFrames(rolls);
        frames.add(bonusFrame(lastTurn(frames), rolls));
        return frames;
    }

    private ArrayList<Frame> normalFrames(ArrayList<Roll> rolls) {
        ArrayList<Frame> frames = new ArrayList<>();
        int numberOfRoll = 0;
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            Frame frame = getTurn(numberOfRoll, rolls);
            frames.add(frame);
            numberOfRoll += frame.isStrike() ? 1 : 2;
        }
        return frames;
    }

    private BonusFrame bonusFrame(Frame lastFrame, ArrayList<Roll> rolls) {
        if (lastFrame.isSpare()) {
            return spareBonus(rolls);
        }
        if (lastFrame.isStrike()) {
            return strikeBonus(rolls);
        }
        return noBonus();
    }


    private Frame getTurn(int startingRoll, ArrayList<Roll> rolls) {
        Roll firstRoll = rolls.get(startingRoll);
        if (firstRoll.numberOfKnockedPins() == 10) {
            return new Strike(firstRoll);
        }
        Roll secondRoll = rolls.get(startingRoll + 1);
        if (firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins() == 10) {
            return new Spare(firstRoll, secondRoll);
        }
        return new Frame(firstRoll, secondRoll);
    }

    private Frame lastTurn(ArrayList<Frame> frames) {
        return frames.get(frames.size() - 1);
    }

    private NoBonusFrame noBonus() {
        return new NoBonusFrame();
    }

    private BonusFrame spareBonus(ArrayList<Roll> rolls) {
        Roll lastRoll = getRollStartingByTheEnd(0, rolls);
        return new BonusFrame(lastRoll);
    }

    private BonusFrame strikeBonus(ArrayList<Roll> rolls) {
        Roll lastRoll = getRollStartingByTheEnd(0, rolls);
        Roll penultimateRoll = getRollStartingByTheEnd(1, rolls);

        return new BonusFrame(penultimateRoll, lastRoll);
    }

    private Roll getRollStartingByTheEnd(int positionFromEnd, ArrayList<Roll> rolls) {
        int realPosition = rolls.size() - (positionFromEnd + 1);
        return rolls.get(realPosition);
    }
}
