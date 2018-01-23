import model.cards.Card;
import model.cards.Deck;
import model.cards.DeckAgeI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTests {

    @Test
    void testCreateDeckAgeIFor3Players() {
        Deck deck = new DeckAgeI(3);
        List<Card> cards = deck.getCards();
        assertEquals(48, cards.size());
    }

    @Test
    void testCreateDeckAgeIFor7Players() {
        Deck deck = new DeckAgeI(7);
        List<Card> cards = deck.getCards();
        assertEquals(52, cards.size());
    }

}
