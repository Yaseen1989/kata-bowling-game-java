package com.luisrovirosa.katas.bowling;

public class GameScorer {
    private Game game;

    public GameScorer(Game game) {
        this.game = game;
    }

    public int score() {
        int result = 0;
        for (Turn turn : game.turns()) {
            result += turnScore(turn);
        }
        return result;

    }

    private int turnScore(Turn turn) {
        return turn.numberOfKnockedPins() + bonusScore(turn);
    }

    private int bonusScore(Turn turn) {
        if (!turn.hasKnockAllThePins()) {
            return 0;
        }

        Turn nextTurn = game.next(turn);
        if (turn.isSpare()) {
            return nextTurn.numberOfPinsKnockedInFirstRoll();
        }

        if (nextTurn.isStrike()) {
            return nextTurn.numberOfKnockedPins() + game.next(nextTurn).numberOfPinsKnockedInFirstRoll();
        } else {
            return nextTurn.numberOfKnockedPins();
        }
    }

}
