package com.luisrovirosa.katas.bowling;

public class Strike extends Turn {

    public Strike(NormalRoll roll) {
        super(roll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
