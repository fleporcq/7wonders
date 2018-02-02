package model.wonderboards;

import model.Resource;
import model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class WonderBoard {

    private City city;

    private Side side;

    private List<Resource> resources = new ArrayList<>();

    private int coins;

    private List<Card> builtCards = new ArrayList<>();

    public WonderBoard(City city, Side side) {
        if (city == null)
            throw new IllegalArgumentException("The wonderboard's city cannot be null");
        if (side == null)
            throw new IllegalArgumentException("The wonderboard's side cannot be null");
        this.city = city;
        this.side = side;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Card> getBuiltCards() {
        return builtCards;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public void addCoins(int amount) {
        if (amount < 1)
            throw new IllegalArgumentException("The amount must be at least 1");
        coins += amount;
    }

    public void removeCoins(int amount) {
        if (amount < 1)
            throw new IllegalArgumentException("The amount must be at least 1");
        coins -= amount;
    }

    public int getCoins() {
        return coins;
    }

    public boolean has(Resource type, int count) {
        int total = 0;
        for (Resource resource : resources) {
            if (resource == type)
                total++;
        }
        return total >= count;
    }

    public boolean has(Resource type) {
        return has(type, 1);
    }

    public void build(Card card) {
        builtCards.add(card);
    }

    @Override
    public String toString() {
        return city + " " + side;
    }

}
