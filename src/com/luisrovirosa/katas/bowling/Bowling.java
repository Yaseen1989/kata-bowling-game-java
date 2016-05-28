package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        int result = 0;
        for (int i = 0; i < rolls.length(); i++) {
            result += rollScore(rolls, i);
            result += bonusScore(rolls, i);
        }
        return result;
    }

    private int rollScore(String rolls, int numberOfRoll) {
        String score = rolls.substring(numberOfRoll, numberOfRoll + 1);
        if (score.equals("-")) {
            score = "0";
        } else if (score.equals("/")) {
            score = String.valueOf(10 - rollScore(rolls, numberOfRoll - 1));
        } else if (score.equals("X")) {
            score = "10";
        }
        return Integer.parseInt(score);
    }

    private int bonusScore(String rolls, int numberOfRoll) {
        int bonus = 0;
        if (numberOfRoll % 2 == 0 && numberOfRoll < rolls.length() - 1 && rollScore(rolls, numberOfRoll) + rollScore(rolls, numberOfRoll + 1) == 10) {
            bonus = rollScore(rolls, numberOfRoll + 2);
        }
        return bonus;
    }
}
