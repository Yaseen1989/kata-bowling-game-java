package com.luisrovirosa.katas.bowling.frame.bonus;

import com.luisrovirosa.katas.bowling.roll.MissRoll;

public class NoBonusFrame extends BonusFrame {
    public NoBonusFrame() {
        super(new MissRoll());
    }
}
