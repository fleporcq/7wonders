package model.bonuses;

import model.Bonus;
import model.wonderboards.WonderBoard;

public enum ScientificSymbol implements Bonus {
    WHEEL,
    TABLET,
    COMPASS;

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addScientificSymbol(this);
    }
}
