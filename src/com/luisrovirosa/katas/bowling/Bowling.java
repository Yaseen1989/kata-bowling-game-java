package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        int result = 0;
        for (int i = 0; i < 20; i++){
            result += rollScore(rolls, i);
        }
        return result;
    }

    private int rollScore(String rolls, int numberOfRoll) {
        String score = rolls.substring(numberOfRoll, numberOfRoll +1);
        if (score.equals("-")){
            score = "0";
        }
        return Integer.parseInt(score);
    }
}
