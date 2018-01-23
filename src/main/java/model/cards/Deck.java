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
        shuffle();
    }

    private void selectCards(int playerCount) {
        for (Card card : allCards) {
            if (card.isPlayableFor(playerCount))
                selectedCards.add(card);
        }
    }

    protected Card createCard(CardType type, String name, int minPlayerCount) {
        Card card = new Card(age, type, name, minPlayerCount);
        return card;
    }

    protected void add(Card card) {
        add(card, 1);
    }

    protected void add(Card card, int quantity) {
        if (card.getAge() != age)
            throw new IllegalArgumentException("This card is not of the age " + age);
        if (quantity < 1)
            throw new IllegalArgumentException("The cards quantity must be greater than 0");
        allCards.add(card);
        for (int i = 1; i < quantity; i++) {
            allCards.add(card.clone());
        }
    }

    protected abstract void build();

    private void shuffle() {
        Collections.shuffle(selectedCards);
    }

    public List<Card> getCards() {
        return selectedCards;
    }
}
