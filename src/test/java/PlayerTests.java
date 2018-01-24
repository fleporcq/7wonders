import model.Game;
import model.Player;
import model.cards.Card;
import model.cards.Deck;
import model.cards.DeckAgeI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTests {

    @Test
    void testCreatePlayerWithEmptyName() {
        try {
            new Player(null);
        } catch (IllegalArgumentException e) {
            assertEquals("The player's name cannot be null or empty", e.getMessage());
        }
        try {
            new Player("");
        } catch (IllegalArgumentException e) {
            assertEquals("The player's name cannot be null or empty", e.getMessage());
        }
        try {
            new Player("  ");
        } catch (IllegalArgumentException e) {
            assertEquals("The player's name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    void testAPlayerChooseACard(){
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        Deck deck = new DeckAgeI(3);
        game.handOutCards(deck);
        Card card = francois.getHand().getCards().get(0);
        assertEquals(16, francois.getHand().getCards().size());
        francois.choose(card);
        assertTrue(francois.hasChosenACard());
        assertEquals(15, francois.getHand().getCards().size());
    }
}
