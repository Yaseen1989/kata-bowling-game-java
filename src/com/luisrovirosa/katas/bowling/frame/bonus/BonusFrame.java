package com.luisrovirosa.katas.bowling.frame.bonus;

import com.luisrovirosa.katas.bowling.frame.Frame;
import com.luisrovirosa.katas.bowling.roll.Roll;

public class BonusFrame extends Frame {
    public BonusFrame(Roll roll) {
        super(roll);
    }

    public BonusFrame(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }
}
