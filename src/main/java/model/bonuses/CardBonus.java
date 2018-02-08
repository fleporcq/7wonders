package model.bonuses;

import model.Bonus;
import model.Direction;
import model.cards.CardType;
import model.wonderboards.WonderBoard;

public class CardBonus implements Bonus {

    private CardType cardType;

    private int coins;

    private int victoryPoints;

    private Direction direction;

    public CardBonus(CardType cardType, int coins, int victoryPoints, Direction direction) {
        this.cardType = cardType;
        this.coins = coins;
        this.victoryPoints = victoryPoints;
        this.direction = direction;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        WonderBoard from = getFromWonderBoard(wonderBoard);
        wonderBoard.addCoins(from.countBuiltCards(cardType) * coins);
    }

    @Override
    public void applyEnd(WonderBoard wonderBoard) {
        WonderBoard from = getFromWonderBoard(wonderBoard);
        wonderBoard.addVictoryPoints(from.countBuiltCards(cardType) * victoryPoints);
    }

    private WonderBoard getFromWonderBoard(WonderBoard wonderBoard) {
        WonderBoard from;
        switch (direction) {
            case LEFT:
                from = wonderBoard.getOwner().getLeftNeighbor().getWonderBoard();
                break;
            case RIGHT:
                from = wonderBoard.getOwner().getRightNeighbor().getWonderBoard();
                break;
            default:
            case ME:
                from = wonderBoard;
                break;
        }
        return from;
    }
}
