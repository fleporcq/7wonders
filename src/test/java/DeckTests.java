import model.cards.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTests {

    @Test
    void testCreateDeckAgeIFor3Players() {
        Deck deck = new DeckAgeI(3);
        assertEquals(21, deck.getCards().size());
    }

    @Test
    void testCreateDeckAgeIFor7Players() {
        Deck deck = new DeckAgeI(7);
        assertEquals(49, deck.getCards().size());
    }

    @Test
    void testShuffleDeck() {
        Deck deck = new DeckAgeI(3);
        List<Card> cards = deck.getCards();
        String beforeCardNames = getCardsNames(cards, 4);
        assertEquals("lumber yard,stone pit,clay pool,ore vein", beforeCardNames);
        deck.shuffle();
        String afterCardNames = getCardsNames(cards, 4);
        assertNotEquals("lumber yard,stone pit,clay pool,ore vein", afterCardNames);
    }

    private String getCardsNames(List<Card> cards, int limit) {
        return cards.stream().limit(limit).map(c -> c.getName()).collect(Collectors.joining(","));
    }

    @Test
    void testCreateDeckAgeIIFor3Players() {
        Deck deck = new DeckAgeII(3);
        assertEquals(21, deck.getCards().size());
    }

    @Test
    void testCreateDeckAgeIIFor7Players() {
        Deck deck = new DeckAgeII(7);
        assertEquals(49, deck.getCards().size());
    }

    @Test
    void testCreateDeckAgeIIIFor3Players() {
        Deck deck = new DeckAgeIII(3);
        assertEquals(21, deck.getCards().size());
    }

    @Test
    void testCreateDeckAgeIIIFor7Players() {
        Deck deck = new DeckAgeIII(7);
        assertEquals(49, deck.getCards().size());
    }
}
