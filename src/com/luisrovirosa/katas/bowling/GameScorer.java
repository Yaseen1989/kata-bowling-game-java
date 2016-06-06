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
        if (turn.isSpare()) {
            return spareBonus(turn);
        }

        if (turn.isStrike()) {
            return strikeBonus(turn);
        }

        return 0;
    }

    private int spareBonus(Turn turn) {
        Turn nextTurn = game.next(turn);
        return nextTurn.numberOfPinsKnockedInFirstRoll();
    }

    private int strikeBonus(Turn turn) {
        Turn nextTurn = game.next(turn);
        if (nextTurn.isStrike()) {
            return nextTurn.numberOfPinsKnockedInFirstRoll() + game.next(nextTurn).numberOfPinsKnockedInFirstRoll();
        }
        return nextTurn.numberOfKnockedPins();
    }

}
