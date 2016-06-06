package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.roll.Roll;

public class Spare extends Frame {
    public Spare(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
