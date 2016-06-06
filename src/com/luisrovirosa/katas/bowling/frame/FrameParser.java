package com.luisrovirosa.katas.bowling.frame;

import com.luisrovirosa.katas.bowling.roll.Roll;

import java.util.ArrayList;

public class FrameParser {

    public ArrayList<Frame> parse(ArrayList<Roll> rolls) {
        ArrayList<Frame> frames = new ArrayList<>();
        int numberOfRoll = 0;
        while (numberOfRoll < rolls.size()){
            Frame frame = getTurn(numberOfRoll, rolls);
            frames.add(frame);
            numberOfRoll += frame.isStrike() ? 1 : 2;
        }
        return frames;
    }

    private Frame getTurn(int startingRoll, ArrayList<Roll> rolls) {
        Roll firstRoll = getRoll(startingRoll, rolls);
        if (firstRoll.numberOfKnockedPins() == 10) {
            return new Strike(firstRoll);
        }
        Roll secondRoll = getRoll(startingRoll + 1, rolls);
        if (firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins() == 10) {
            return new Spare(firstRoll, secondRoll);
        }
        return new Frame(firstRoll, secondRoll);
    }

    private Roll getRoll(int rollNumber, ArrayList<Roll> rolls) {
        return rollNumber < rolls.size() ? rolls.get(rollNumber) : Roll.miss();
    }
}
