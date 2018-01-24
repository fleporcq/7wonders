import model.Game;
import model.Player;
import model.cards.Card;
import model.cards.Deck;
import model.cards.DeckAgeI;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void testAPlayerChooseACard() {
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

    @Test
    void testAPlayerBuildACard() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        List<WonderBoard> wonderBoards = wonderBoardFactory.getRandomWonderBoards();
        game.handOutWonderBoards(wonderBoards);
        Deck deck = new DeckAgeI(3);
        game.handOutCards(deck);
        Card card = francois.getHand().getCards().get(0);
        francois.choose(card);
        francois.build(card);
        assertFalse(francois.hasChosenACard());
        assertEquals(1, francois.getWonderBoard().getBuiltCards().size());
    }
}
