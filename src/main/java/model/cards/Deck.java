package model.cards;

import model.Age;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck {
    protected List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    protected Card add(CardType type, String name){
        Card card = new Card(Age.I, type, name);
        cards.add(card);
        return card;
    }
}
