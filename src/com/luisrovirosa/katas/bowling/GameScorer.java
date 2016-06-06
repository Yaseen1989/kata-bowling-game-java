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

        Turn next = game.next(turn);
        if (turn.isSpare()) {
            return next.numberOfPinsKnockedInFirstRoll();
        }

        if (next.isStrike()) {
            return next.numberOfKnockedPins() + game.next(next).numberOfPinsKnockedInFirstRoll();
        } else {
            return next.numberOfKnockedPins();
        }
    }

}
