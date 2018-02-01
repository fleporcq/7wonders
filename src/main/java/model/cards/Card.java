package model.cards;

import model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Card implements Cloneable {

    private Age age;

    private CardType type;

    private String name;

    private int minPlayerCount;

    private List<Bonus> bonuses = new ArrayList<>();

    private List<Cost> costs = new ArrayList<>();

    public Card(Age age, CardType type, String name) {
        this.age = age;
        this.type = type;
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void addBonuses(Bonus... bonuses) {
        for (int i = 0; i < bonuses.length; i++) {
            this.bonuses.add(bonuses[i]);
        }
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void addCosts(Cost... costs) {
        for (int i = 0; i < costs.length; i++) {
            this.costs.add(costs[i]);
        }
    }

    public List<Cost> getCosts() {
        return costs;
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

    public boolean validatePayment(Payment... payments) {
        List<Cost> costs = new ArrayList<>();
        costs.addAll(getCosts());
        for (Payment payment : payments) {
            if (payment instanceof Resource) {
                Resource resource = (Resource) payment;
                if (costs.contains(resource))
                    costs.remove(resource);
            } else if (payment instanceof Buy) {
                Resource resource = ((Buy) payment).getResource();
                if (costs.contains(resource))
                    costs.remove(resource);
            } else if (payment instanceof Coin) {
                Iterator<Cost> it = costs.iterator();
                while (it.hasNext()) {
                    Cost cost = it.next();
                    if (cost instanceof Coin) {
                        it.remove();
                        break;
                    }
                }
            }

        }
        return costs.size() == 0;
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
