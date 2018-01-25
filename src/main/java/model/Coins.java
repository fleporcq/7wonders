package model;

import model.wonderboards.WonderBoard;

public class Coins implements Bonus, Cost {

    private int amount;

    public Coins(int amount) {
        if (amount < 1)
            throw new IllegalArgumentException("The amount must be at least 1");
        this.amount = amount;
    }

    @Override
    public void apply(WonderBoard wonderBoard) {
        wonderBoard.addCoins(amount);
    }

    @Override
    public void pay(WonderBoard wonderBoard) {
        if(wonderBoard.getCoins() < amount)
            throw new RulesViolationException("You have not enough coins to pay");
        wonderBoard.removeCoins(amount);
    }
}
