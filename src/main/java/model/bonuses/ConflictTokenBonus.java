package model.bonuses;

import model.Bonus;
import model.ConflictToken;
import model.Direction;
import model.wonderboards.WonderBoard;

public class ConflictTokenBonus implements Bonus {

    private ConflictToken conflictToken;

    private int coins;

    private int victoryPoints;

    private Direction direction;

    public ConflictTokenBonus(ConflictToken conflictToken, int coins, int victoryPoints, Direction direction) {
        this.conflictToken = conflictToken;
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
