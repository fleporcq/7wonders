package model;

import model.cards.Card;
import model.wonderboards.WonderBoard;

public class Player {

    private String name;

    private WonderBoard wonderBoard;

    private Hand hand = new Hand();

    public Player(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The player's name cannot be null or empty");
        this.name = name;
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
        if (!hand.contains(card))
            throw new IllegalArgumentException("This card is not part of your hand");
        hand.remove(card);
        hand.setChoice(card);
    }

    public boolean hasChosenACard() {
        return hand.getChoice() != null;
    }

    public void build(Card card) {
        if(wonderBoard == null)
            throw new IllegalStateException("The wonder boards have not yet hand out");
        hand.setChoice(null);
        wonderBoard.build(card);
    }
}
