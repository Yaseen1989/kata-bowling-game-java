package com.luisrovirosa.katas.bowling;

public class RollParser {
    public int[] parse(String rolls) {
        int[] result = new int[rolls.length()];
        for (int i = 0; i < rolls.length(); i++) {
            result[i] = scoreOf(rolls, i);
        }
        return result;
    }

    private int scoreOf(String rolls, int numberOfRoll) {
        String score = rolls.substring(numberOfRoll, numberOfRoll + 1);
        if (score.equals("-")) {
            score = "0";
        } else if (score.equals("/")) {
            score = String.valueOf(10 - scoreOf(rolls, numberOfRoll - 1));
        } else if (score.equals("X")) {
            score = "10";
        }
        return Integer.parseInt(score);
    }
}
