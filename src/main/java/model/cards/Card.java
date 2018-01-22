package model.cards;

import model.Age;

public class Card {

    private Age age;

    private CardType type;

    private String name;

    public Card(Age age, CardType type, String name) {
        this.age = age;
        this.name = name;
    }
}
