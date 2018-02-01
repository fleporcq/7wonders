import model.Buy;
import model.Coin;
import model.Direction;
import model.Resource;
import model.cards.Card;
import model.cards.DeckAgeI;
import model.cards.DeckAgeIII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTests {

    @Test
    void testValidateAPaymentWithOneOfMyResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        boolean valid = stockade.validatePayment(Resource.WOOD);
        assertTrue(valid);
    }

    @Test
    void testValidateAPaymentWithOneOfNeighborResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        boolean valid = stockade.validatePayment(new Buy(Resource.WOOD, Direction.LEFT));
        assertTrue(valid);
    }

    @Test
    void testInvalidateAPaymentWithOneOfMyResources() {
        DeckAgeI deck = new DeckAgeI(3);
        Card stockade = deck.getCard("stockade");
        boolean valid = stockade.validatePayment(Resource.CLAY);
        assertFalse(valid);
    }

    @Test
    void testValidateAPaymentWithOneCoin() {
        DeckAgeI deck = new DeckAgeI(3);
        Card clayPit = deck.getCard("clay pit");
        boolean valid = clayPit.validatePayment(new Coin());
        assertTrue(valid);
    }

    @Test
    void testValidateAPaymentWithMultipleResources() {
        DeckAgeIII deck = new DeckAgeIII(3);
        Card stockade = deck.getCard("university");
        boolean valid = stockade.validatePayment(Resource.WOOD, new Buy(Resource.WOOD, Direction.LEFT), Resource.PAPYRUS, new Buy(Resource.GLASS, Direction.RIGHT));
        assertTrue(valid);
    }
}
