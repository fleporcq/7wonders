package model;

import model.wonderboards.WonderBoard;

import java.util.ArrayList;
import java.util.List;

public enum Resource implements Bonus, Cost, Payment {
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
    public List<Cost> getCosts() {
        List<Cost> costs = new ArrayList<>();
        costs.add(this);
        return costs;
    }
}
