package model.bonuses;

import model.Bonus;
import model.Direction;
import model.wonderboards.WonderBoard;

public class WonderBonus implements Bonus {

    private int coins;

    private int victoryPoints;

    private Direction direction;

    public WonderBonus(int coins, int victoryPoints, Direction direction) {
        this.coins = coins;
        this.victoryPoints = victoryPoints;
        this.direction = direction;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        // TODO: 09/02/18  
    }

    @Override
    public void applyEnd(WonderBoard wonderBoard) {
        // TODO: 09/02/18  
    }
}
