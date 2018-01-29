package model.wonderboards;

import model.Bonus;
import model.Cost;
import model.RulesViolationException;
import model.cards.Card;
import model.Resource;

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

    @Override
    public String toString() {
        return city + " " + side;
    }

    public void build(Card card) {
        List<Cost> costs = card.getCosts();

        if (!canPay(costs))
            throw new RulesViolationException("You have not enough resources or coins to pay this card");

        builtCards.add(card);

        for (Cost cost : costs) {
            cost.pay(this);
        }

        for (Bonus bonus : card.getBonuses()) {
            bonus.apply(this);
        }
    }

    private boolean canPay(List<Cost> costs) {
        return true;
    }
}
