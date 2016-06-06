package com.luisrovirosa.katas.bowling;

public class Turn {
    private static final int NUMBER_OF_PINS = 10;
    private NormalRoll firstRoll;
    private NormalRoll secondRoll;

    protected Turn(NormalRoll roll) {
        firstRoll = roll;
        secondRoll = new NormalRoll(0);
    }

    public Turn(NormalRoll firstRoll, NormalRoll secondRoll) {
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
