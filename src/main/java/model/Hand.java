package model;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();

    private Card choice;

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getChoice() {
        return choice;
    }

    public void setChoice(Card choice) {
        this.choice = choice;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public void remove(Card card) {
        cards.remove(card);
    }
}
