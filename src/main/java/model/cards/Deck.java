package model.cards;

import model.Age;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.Age.III;
import static model.Game.PLAYER_MAX;
import static model.Game.PLAYER_MIN;
import static model.cards.CardType.GUILD;


public abstract class Deck {

    protected Age age;
    protected List<Card> standardCards = new ArrayList<>();
    protected List<Card> guildCards = new ArrayList<>();
    protected List<Card> selectedCards = new ArrayList<>();

    public Deck(Age age, int playerCount) {
        if (playerCount < PLAYER_MIN || playerCount > PLAYER_MAX)
            throw new IllegalArgumentException("The player count must be between " + PLAYER_MIN + " and " + PLAYER_MAX);
        this.age = age;
        build();
        selectCards(playerCount);
        if (age == III)
            selectGuilds(playerCount);
    }

    private void selectCards(int playerCount) {
        for (Card card : standardCards) {
            if (card.isPlayableFor(playerCount))
                selectedCards.add(card);
        }
    }

    private void selectGuilds(int playerCount) {
        Collections.shuffle(guildCards);
        int guildsCount = playerCount + 2;
        selectedCards.addAll(guildCards.subList(0, guildsCount));
    }

    protected Card createCard(CardType type, String name) {
        return new Card(age, type, name);
    }

    protected void addGuild(Card card) {
        if (card.getType() != GUILD)
            throw new IllegalArgumentException("The card must be a guild");
        guildCards.add(card);
    }

    protected void add(Card card, int... minPlayerCounts) {
        if (card.getType() == GUILD)
            throw new IllegalArgumentException("The card cannot be a guild");
        if (card.getAge() != age)
            throw new IllegalArgumentException("This card is not of the age " + age);
        if (minPlayerCounts.length < 1)
            throw new IllegalArgumentException("You must add at least one card");
        for (int i = 0; i < minPlayerCounts.length; i++) {
            Card clone = card.clone();
            clone.setMinPlayerCount(minPlayerCounts[i]);
            standardCards.add(clone);
        }
    }

    protected abstract void build();

    public void shuffle() {
        Collections.shuffle(selectedCards);
    }

    public List<Card> getCards() {
        return selectedCards;
    }

    public Card getCard(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The card's name cannot be null or empty");
        for(Card card: selectedCards){
            if(name.equals(card.getName()))
                return card;
        }
        throw new IllegalArgumentException("This card is not a part of this deck");
    }
}
