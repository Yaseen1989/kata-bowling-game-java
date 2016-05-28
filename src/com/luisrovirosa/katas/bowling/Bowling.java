package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        String score = rolls.substring(0, 1);
        if (score.equals("-")){
            score = "0";
        }
        return Integer.parseInt(score);
    }
}
