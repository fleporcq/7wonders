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

    Card getChoice() {
        return choice;
    }

    void setChoice(Card choice) {
        this.choice = choice;
    }

    boolean contains(Card card) {
        return cards.contains(card);
    }

    void remove(Card card) {
        cards.remove(card);
    }

    public Card get(String name){
        return cards.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }
}
