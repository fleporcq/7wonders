package model;

import model.wonderboards.WonderBoard;

public class Coin implements Bonus, Cost, Payment {

    @Override
    public void apply(WonderBoard wonderBoard) {
        wonderBoard.addCoins(1);
    }
}
