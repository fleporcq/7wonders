package model.cards;

import model.Age;
import model.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {

    protected Age age;
    protected List<Card> allCards = new ArrayList<>();
    protected List<Card> selectedCards = new ArrayList<>();

    public Deck(Age age, int playerCount) {
        if (playerCount < Game.PLAYER_MIN || playerCount > Game.PLAYER_MAX)
            throw new IllegalArgumentException("The player count must be between " + Game.PLAYER_MIN + " and " + Game.PLAYER_MAX);
        this.age = age;
        build();
        selectCards(playerCount);
    }

    private void selectCards(int playerCount) {
        for (Card card : allCards) {
            if (card.isPlayableFor(playerCount))
                selectedCards.add(card);
        }
    }

    protected Card createCard(CardType type, String name) {
        return new Card(age, type, name);
    }

    protected void add(Card card, int... minPlayerCounts) {
        if (card.getAge() != age)
            throw new IllegalArgumentException("This card is not of the age " + age);
        if (minPlayerCounts.length < 1)
            throw new IllegalArgumentException("You must add at least one card");
        for (int i = 0; i < minPlayerCounts.length; i++) {
            Card clone = card.clone();
            clone.setMinPlayerCount(minPlayerCounts[i]);
            allCards.add(clone);
        }
    }

    protected abstract void build();

    public void shuffle() {
        Collections.shuffle(selectedCards);
    }

    public List<Card> getCards() {
        return selectedCards;
    }
}
