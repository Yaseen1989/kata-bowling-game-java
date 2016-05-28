package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        if (rolls.substring(0,1).equals("-")){
            return 0;
        }
        return 1;
    }
}
