package model.bonuses;

import model.Bonus;
import model.wonderboards.WonderBoard;

public class Shield implements Bonus {

    private int value;

    public Shield(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The value must be at least 1");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addShields(value);
    }
}
