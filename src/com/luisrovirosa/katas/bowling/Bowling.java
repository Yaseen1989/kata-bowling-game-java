package com.luisrovirosa.katas.bowling;

public class Bowling {
    public int scoreOf(String rolls) {
        int result = 0;
        int numberOfRoll = 0;
        for (int turn = 0; turn < 10; turn++) {
            result += rollScore(rolls, numberOfRoll);
            if (!isStrike(rolls, numberOfRoll)){
                result += rollScore(rolls, numberOfRoll + 1);
            }
            result += bonusScore(rolls, numberOfRoll);
            numberOfRoll += isStrike(rolls, numberOfRoll) ? 1 : 2;
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
        if (isStrike(rolls, numberOfRoll)){
            bonus = rollScore(rolls, numberOfRoll + 1) + rollScore(rolls, numberOfRoll + 2);
        } else if (isSpare(rolls, numberOfRoll)) {
            bonus = rollScore(rolls, numberOfRoll + 2);
        }
        return bonus;
    }

    private boolean isStrike(String rolls, int numberOfRoll) {
        return 10 == rollScore(rolls, numberOfRoll);
    }

    private boolean isSpare(String rolls, int numberOfRoll) {
        return rollScore(rolls, numberOfRoll) + rollScore(rolls, numberOfRoll + 1) == 10;
    }
}
