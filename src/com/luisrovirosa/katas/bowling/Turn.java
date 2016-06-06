package com.luisrovirosa.katas.bowling;

public class Turn {
    private static final int NUMBER_OF_PINS = 10;
    private Roll firstRoll;
    private Roll secondRoll;

    protected Turn(Roll roll) {
        firstRoll = roll;
        secondRoll = new NormalRoll(0);
    }

    public Turn(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int basicScore() {
        return firstRoll.numberOfKnockedPins() + secondRoll.numberOfKnockedPins();
    }

    public int firstRollScore() {
        return firstRoll.numberOfKnockedPins();
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean hasKnockAllThePins() {
        return basicScore() == NUMBER_OF_PINS;
    }
}
