package model.cards;

import model.Age;
import model.bonus.Bonus;
import model.costs.Cost;

import java.util.List;

public abstract class Card {

    private Age age;

    private String name;

    private Cost cost;

    private Bonus bonus;

    private List<Card> previousBuiltForFree;

    private List<Card> nextBuiltForFree;

    private int minPlayers;

    public Card(Age age, String name, Bonus bonus, int minPlayers) {
        this.age = age;
        this.name = name;
        this.bonus = bonus;
        this.minPlayers = minPlayers;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public void setPreviousBuiltForFree(List<Card> previousBuiltForFree) {
        this.previousBuiltForFree = previousBuiltForFree;
    }

    public void setNextBuiltForFree(List<Card> nextBuiltForFree) {
        this.nextBuiltForFree = nextBuiltForFree;
    }

    public Age getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Cost getCost() {
        return cost;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public List<Card> getPreviousBuiltForFree() {
        return previousBuiltForFree;
    }

    public List<Card> getNextBuiltForFree() {
        return nextBuiltForFree;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
