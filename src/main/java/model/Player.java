package model;

import model.cards.Card;
import model.wonderboards.WonderBoard;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private WonderBoard wonderBoard;

    private Hand hand = new Hand();

    private Game game;

    boolean played;

    public Player(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The player's name cannot be null or empty");
        this.name = name;
    }

    void setGame(Game game) {
        if (this.game != null)
            throw new IllegalStateException("The game is already setted");
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setWonderBoard(WonderBoard wonderBoard) {
        this.wonderBoard = wonderBoard;
    }

    public WonderBoard getWonderBoard() {
        return wonderBoard;
    }

    public Hand getHand() {
        return hand;
    }

    public void choose(Card card) {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        hand.choose(card);
    }

    public void cancelChoice() {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("You cannot cancel your choice because all players have chosen a card");
        hand.cancelChoice();
    }

    public boolean hasChosenACard() {
        return hand.hasChoice();
    }

    public void build(Payment... payments) {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");

        Card card = hand.getChoice();
        if (!card.validatePayment(payments))
            throw new RulesViolationException("Your payment is incorrect");

        if (pay(payments)) {
            card = hand.popChoice();
            wonderBoard.build(card);
            played = true;
        } else {
            throw new RulesViolationException("You cannot pay this card");
        }
    }

    public boolean pay(Payment... payments) {

        List<Resource> playerResources = new ArrayList<>();
        List<Resource> leftResources = new ArrayList<>();
        List<Resource> rightResources = new ArrayList<>();

        if (wonderBoard != null)
            playerResources.addAll(wonderBoard.getResources());

        Player leftNeighbor = getLeftNeighbor();
        if (leftNeighbor != null)
            leftResources.addAll(leftNeighbor.getWonderBoard().getResources());

        Player rightNeighbor = getRightNeighbor();
        if (rightNeighbor != null)
            rightResources.addAll(rightNeighbor.getWonderBoard().getResources());

        for (Payment payment : payments) {
            if (payment instanceof Resource) {
                if (!playerResources.contains(payment))
                    return false;
                else
                    playerResources.remove(payment);
            } else if (payment instanceof Buy) {
                Buy buy = (Buy) payment;
                Resource resource = buy.getResource();
                if (buy.getDirection() == Direction.LEFT) {
                    if (!leftResources.contains(resource))
                        return false;
                    else
                        leftResources.remove(resource);
                } else {
                    if (!rightResources.contains(resource))
                        return false;
                    else
                        rightResources.remove(resource);
                }
            } else if (payment instanceof Coin) {
                if (wonderBoard != null && wonderBoard.getCoins() > 0)
                    wonderBoard.removeCoins(1);
                else
                    return false;
            }
        }
        return true;
    }

    public Player getLeftNeighbor() {
        if (game == null)
            return null;
        return game.getLeftNeighbor(this);
    }

    public Player getRightNeighbor() {
        if (game == null)
            return null;
        return game.getRightNeighbor(this);
    }

    public void sell() {
        if (played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");
        hand.popChoice();
        wonderBoard.addCoins(Game.CARD_DISCARDING_AMOUT);
        played = true;
    }
}
