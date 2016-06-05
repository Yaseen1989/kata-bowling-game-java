package com.luisrovirosa.katas.bowling;

public class GameScorer {
    private Game game;

    public GameScorer(Game game) {
        this.game = game;
    }

    public int score() {
        int result = 0;
        for (int numberOfTurn = 0; numberOfTurn < 10; numberOfTurn++) {
            Turn turn = game.turn(numberOfTurn);
            result += turnScore(turn);
        }
        return result;

    }

    private int turnScore(Turn turn) {
        return turn.basicScore() + bonusScore(turn);
    }

    private int bonusScore(Turn turn) {
        if (!turn.hasBonus()) {
            return 0;
        }

        Turn next = game.next(turn);
        if (turn.isSpare()) {
            return next.firstRollScore();
        }

        if (next.isStrike()) {
            return next.basicScore() + game.next(next).firstRollScore();
        } else {
            return next.basicScore();
        }
    }

}
