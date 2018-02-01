package model;

import model.wonderboards.WonderBoard;

public class Coin implements Bonus, Cost, Payment {

    @Override
    public void apply(WonderBoard wonderBoard) {
        wonderBoard.addCoins(1);
    }

    @Override
    public void pay(WonderBoard wonderBoard) {
        if (wonderBoard.getCoins() == 0)
            throw new RulesViolationException("You have not enough coins to pay");
        wonderBoard.removeCoins(1);
    }
}
