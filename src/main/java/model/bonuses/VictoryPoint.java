package model.bonuses;

import model.Bonus;
import model.wonderboards.WonderBoard;

public class VictoryPoint implements Bonus {

    private int value;

    public VictoryPoint(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The value must be at least 1");
        this.value = value;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addVictoryPoints(value);
    }
}
