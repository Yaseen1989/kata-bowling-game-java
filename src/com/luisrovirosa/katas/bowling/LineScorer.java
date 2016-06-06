package com.luisrovirosa.katas.bowling;

public class LineScorer {
    private Line line;

    public LineScorer(Line line) {
        this.line = line;
    }

    public int score() {
        int result = 0;
        for (Turn turn : line.turns()) {
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
        Turn nextTurn = line.next(turn);
        return nextTurn.numberOfPinsKnockedInFirstRoll();
    }

    private int strikeBonus(Turn turn) {
        Turn nextTurn = line.next(turn);
        if (nextTurn.isStrike()) {
            return nextTurn.numberOfPinsKnockedInFirstRoll() + line.next(nextTurn).numberOfPinsKnockedInFirstRoll();
        }
        return nextTurn.numberOfKnockedPins();
    }

}
