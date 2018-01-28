package model;

import model.cards.Card;
import model.wonderboards.WonderBoard;

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
        if(played)
            throw new RulesViolationException("You have already played for this turn");
        hand.choose(card);
    }

    public void cancelChoice() {
        if(played)
            throw new RulesViolationException("You have already played for this turn");
        if (game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("You cannot cancel your choice because all players have chosen a card");
        hand.cancelChoice();
    }

    public boolean hasChosenACard() {
        return hand.hasChoice();
    }

    public void build() {
        if(played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");
        Card card = hand.popChoice();
        wonderBoard.build(card);
        played = true;
    }

    public void sell() {
        if(played)
            throw new RulesViolationException("You have already played for this turn");
        if (!game.allPlayersHaveChoosenACard())
            throw new RulesViolationException("All players have not yet chosen a card");
        hand.popChoice();
        wonderBoard.addCoins(Game.CARD_DISCARDING_AMOUT);
        played = true;
    }
}
