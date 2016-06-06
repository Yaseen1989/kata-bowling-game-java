package com.luisrovirosa.katas.bowling;

public class Frame {
    private static final int NUMBER_OF_PINS = 10;
    private Roll firstRoll;
    private Roll secondRoll;

    protected Frame(Roll roll) {
        firstRoll = roll;
        secondRoll = new MissRoll();
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

    public boolean hasKnockAllThePins() {
        return numberOfKnockedPins() == NUMBER_OF_PINS;
    }
}
