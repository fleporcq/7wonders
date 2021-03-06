import model.*;
import model.cards.Card;
import model.cards.CardType;
import model.cards.DeckAgeI;
import model.cards.DeckAgeIII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTests {

    @Test
    void createANewCard() {
        try {
            new Card(null, CardType.MILITARY_STRUCTURE, "stockade");
        } catch (IllegalArgumentException e) {
            assertEquals("The card's age cannot be null", e.getMessage());
        }
        try {
            new Card(Age.I, null, "stockade");
        } catch (IllegalArgumentException e) {
            assertEquals("The card's type cannot be null", e.getMessage());
        }
        try {
            new Card(Age.I, CardType.MILITARY_STRUCTURE, " ");
        } catch (IllegalArgumentException e) {
            assertEquals("The card's name cannot be null or empty", e.getMessage());
        }
        try {
            new Card(Age.I, CardType.MILITARY_STRUCTURE, null);
        } catch (IllegalArgumentException e) {
            assertEquals("The card's name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    void testToString() {
        Card stockade = new Card(Age.I, CardType.MILITARY_STRUCTURE, "stockade");
        assertEquals("stockade", stockade.toString());
    }

    @Test
    void validateAPaymentWithOneOfMyResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        assertTrue(stockade.validatePayment(Resource.WOOD));
    }

    @Test
    void validateAPaymentWithOneOfNeighborsResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        assertTrue(stockade.validatePayment(new Purchase(Resource.WOOD, Direction.LEFT)));
    }

    @Test
    void invalidateAPaymentWithOneOfMyResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        assertFalse(stockade.validatePayment(Resource.CLAY));
    }

    @Test
    void validateAPaymentWithOneCoin() {
        DeckAgeI deck = new DeckAgeI(3);
        Card clayPit = deck.getCard("clay pit");
        assertTrue(clayPit.validatePayment(new Coin(1)));
    }


    @Test
    void validateAPaymentWithCoins() {
        Card fake = new Card(Age.I, CardType.MILITARY_STRUCTURE, "fake");
        fake.addCosts(new Coin(2), new Coin(1));
        assertTrue(fake.validatePayment(new Coin(3)));
        assertTrue(fake.validatePayment(new Coin(2), new Coin(1)));
        assertFalse(fake.validatePayment(new Coin(1)));
    }

    @Test
    void validateAPaymentWithMultipleResources() {
        DeckAgeIII deck = new DeckAgeIII(3);
        Card stockade = deck.getCard("university");
        assertTrue(stockade.validatePayment(Resource.WOOD, new Purchase(Resource.WOOD, Direction.LEFT), Resource.PAPYRUS, new Purchase(Resource.GLASS, Direction.RIGHT)));
    }
}
