package model;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();

    private Card choice;

    public List<Card> getCards() {
        return cards;
    }

    void add(Card card) {
        cards.add(card);
    }

    public Card get(String name) {
        return cards.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    public Card popChoice() {
        Card card = choice;
        choice = null;
        return card;
    }

    public void cancelChoice() {
        if (choice == null)
            throw new IllegalStateException("You have not yet chosen a card");
        cards.add(choice);
        choice = null;
    }

    public void choose(Card card) {
        if (choice != null)
            throw new IllegalStateException("You have already chosen a card");
        if (!cards.contains(card))
            throw new IllegalArgumentException("This card is not part of your hand");
        cards.remove(card);
        choice = card;
    }

    public boolean hasChoice() {
        return choice != null;
    }
}
