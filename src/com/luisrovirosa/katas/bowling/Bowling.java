package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        int result = 0;
        for (int i = 0; i < 20; i++){
            String score = rolls.substring(i, i+1);
            if (score.equals("-")){
                score = "0";
            }
            result += Integer.parseInt(score);
        }
        return result;
    }
}
