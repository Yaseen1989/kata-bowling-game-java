package com.luisrovirosa.katas.bowling;

public class Spare extends Turn {
    public Spare(NormalRoll firstRoll, NormalRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
