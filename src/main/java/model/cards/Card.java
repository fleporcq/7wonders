package model.cards;

import model.Age;
import model.bonus.Bonus;

import java.util.ArrayList;
import java.util.List;

public class Card implements Cloneable {

    private Age age;

    private CardType type;

    private String name;

    private int minPlayerCount;

    private List<Bonus> bonus = new ArrayList<>();

    public Card(Age age, CardType type, String name) {
        this.age = age;
        this.type = type;
        this.name = name;
    }

    public void setMinPlayerCount(int minPlayerCount) {
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

    public List<Bonus> getBonus() {
        return bonus;
    }
}
