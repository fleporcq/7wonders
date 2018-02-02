package model;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Discarding {

    private List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

}
