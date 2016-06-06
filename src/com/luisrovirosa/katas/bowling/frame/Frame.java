package com.luisrovirosa.katas.bowling.frame;

import com.luisrovirosa.katas.bowling.roll.Roll;

public class Frame {
    private Roll firstRoll;
    private Roll secondRoll;

    protected Frame() {
        this(Roll.miss());
    }

    protected Frame(Roll roll) {
        this(roll, Roll.miss());
    }

    public Frame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int numberOfKnockedPins() {
        return firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins();
    }

    public int numberOfPinsKnockedInFirstRoll() {
        return firstRoll.numberOfKnockedPins();
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

}
