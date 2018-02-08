package model.wonderboards;

import model.Player;
import model.Resource;
import model.bonuses.Discount;
import model.bonuses.MultiResource;
import model.bonuses.MultiScientificSymbol;
import model.bonuses.ScientificSymbol;
import model.cards.Card;
import model.cards.CardType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WonderBoard {

    private City city;

    private Side side;

    private List<Resource> resources = new ArrayList<>();

    private List<MultiResource> multiResources = new ArrayList<>();

    private List<Discount> discounts = new ArrayList<>();

    private int coins;

    private int victoryPoints;

    private int shields;

    private List<ScientificSymbol> scientificSymbols = new ArrayList<>();

    private List<MultiScientificSymbol> multiScientificSymbols = new ArrayList<>();

    private List<Card> builtCards = new ArrayList<>();

    private Player owner;

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

    public int countBuiltCards(CardType type) {
        return builtCards.stream().filter(c -> c.getType() == type).collect(Collectors.toList()).size();
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public void addMultiResource(MultiResource multiResource) {
        this.multiResources.add(multiResource);
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public void addCoins(int count) {
        if (count < 1)
            throw new IllegalArgumentException("The count must be at least 1");
        coins += count;
    }

    public void removeCoins(int count) {
        if (count < 1)
            throw new IllegalArgumentException("The count must be at least 1");
        coins -= count;
    }

    public void addVictoryPoints(int count) {
        if (count < 1)
            throw new IllegalArgumentException("The count must be at least 1");
        victoryPoints += count;
    }

    public void addShields(int count) {
        if (count < 1)
            throw new IllegalArgumentException("The count must be at least 1");
        shields += count;
    }


    public void addScientificSymbol(ScientificSymbol scientificSymbol) {
        scientificSymbols.add(scientificSymbol);
    }

    public void addMultiScientificSymbol(MultiScientificSymbol multiScientificSymbol) {
        multiScientificSymbols.add(multiScientificSymbol);
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return city + " " + side;
    }
}
