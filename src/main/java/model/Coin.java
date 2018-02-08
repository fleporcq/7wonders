package model;

import model.wonderboards.WonderBoard;

import java.util.ArrayList;
import java.util.List;

public class Coin implements Bonus, Cost, Payment {

    private int value;

    public Coin(int value) {
        if (value < 1)
            throw new IllegalArgumentException("The value must be at least 1");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addCoins(value);
    }

    @Override
    public List<Cost> getCosts() {
        List<Cost> costs = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            costs.add(new Coin(1));
        }
        return costs;
    }
}
