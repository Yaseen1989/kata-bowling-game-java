package com.luisrovirosa.katas.bowling;

import com.luisrovirosa.katas.bowling.roll.Roll;

public class Strike extends Frame {

    public Strike(Roll roll) {
        super(roll);
    }

    @Override
    public boolean isStrike() {
        return true;
    }
}
