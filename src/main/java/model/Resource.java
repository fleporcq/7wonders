package model;

import model.Bonus;
import model.Cost;
import model.wonderboards.WonderBoard;

public enum Resource implements Bonus, Cost {
    CLAY,
    ORE,
    STONE,
    WOOD,
    GLASS,
    LOOM,
    PAPYRUS;

    @Override
    public void apply(WonderBoard wonderBoard) {
        wonderBoard.addResource(this);
    }

    @Override
    public void pay(WonderBoard wonderBoard) {

    }
}
