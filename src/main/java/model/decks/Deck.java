package model.decks;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck<T extends Card> {
    private List<T> cards = new ArrayList<>();

    public void addCard(T card){
        cards.add(card);
    }

}
