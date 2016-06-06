package com.luisrovirosa.katas.bowling.roll;

public class NormalRoll implements Roll {
    private int numberOfKnockedPins;

    public NormalRoll(int numberOfKnockedPins) {
        this.numberOfKnockedPins = numberOfKnockedPins;
    }

    @Override
    public int numberOfKnockedPins() {
        return numberOfKnockedPins;
    }
}
