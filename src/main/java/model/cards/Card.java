package model.cards;

import model.Age;

public class Card implements Cloneable {

    private Age age;

    private CardType type;

    private String name;

    private int minPlayerCount;

    public Card(Age age, CardType type, String name, int minPlayerCount) {
        this.age = age;
        this.type = type;
        this.name = name;
        this.minPlayerCount = minPlayerCount;
    }

    public boolean isPlayableFor(int playerCount) {
        return playerCount >= minPlayerCount;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public Card clone() {
        Card clone = null;
        try {
            clone = (Card) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return name;
    }
}
