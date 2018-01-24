package model.wonderboards;

import model.bonus.Bonus;
import model.cards.Card;
import model.resources.Resource;
import model.resources.ResourceType;

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
        if (city == null)
            throw new IllegalArgumentException("The wonderboard's side cannot be null");
        this.city = city;
        this.side = side;
    }

    public City getCity() {
        return city;
    }

    public Side getSide() {
        return side;
    }

    public List<Card> getBuiltCards() {
        return builtCards;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public void removeCoins(int amount) {
        coins -= amount;
    }

    public int getCoins() {
        return coins;
    }

    public boolean has(ResourceType type, int count) {
        int total = 0;
        for (Resource resource : resources) {
            if (resource.is(type))
                total++;
        }
        return total >= count;
    }

    public boolean has(ResourceType type) {
        return has(type, 1);
    }

    @Override
    public String toString() {
        return city + " " + side;
    }

    public void build(Card card) {
        builtCards.add(card);
        for (Bonus bonus : card.getBonus()) {
            bonus.apply(this);
        }
    }
}
