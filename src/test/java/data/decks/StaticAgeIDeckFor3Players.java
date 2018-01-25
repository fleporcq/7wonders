package data.decks;

import model.Age;
import model.cards.Card;
import model.cards.Deck;

import static model.cards.CardType.RAW_MATERIAL;

public class StaticAgeIDeckFor3Players extends Deck {

    public static final int PLAYERS_COUNT = 3;

    public StaticAgeIDeckFor3Players() {
        super(Age.I, PLAYERS_COUNT);
    }

    @Override
    protected void build() {
        Card lumberYard = createCard(RAW_MATERIAL, "lumber yard");
        add(lumberYard, PLAYERS_COUNT);

        Card stonePit = createCard(RAW_MATERIAL, "stone pit");
        add(stonePit, PLAYERS_COUNT);

        Card clayPool = createCard(RAW_MATERIAL, "clay pool");
        add(clayPool, PLAYERS_COUNT);
    }
}
