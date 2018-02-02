import model.Game;
import model.Player;
import model.RulesViolationException;
import model.cards.DeckAgeI;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    @Test
    void addSomePlayersToTheGame() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        game.addPlayer(new Player("Antoine"));
        game.addPlayer(new Player("Salma"));
        assertEquals("François", game.getPlayer("François").getName());
        assertEquals(4, game.getPlayerCount());
    }

    @Test
    void addTooMuchPlayersToTheGame() {
        Game game = new Game();
        try {
            game.addPlayer(new Player("François"));
            game.addPlayer(new Player("Louise"));
            game.addPlayer(new Player("Antoine"));
            game.addPlayer(new Player("Salma"));
            game.addPlayer(new Player("Myriam"));
            game.addPlayer(new Player("Jean-Marie"));
            game.addPlayer(new Player("Simon"));
            game.addPlayer(new Player("Martin"));
            fail("");
        } catch (RulesViolationException e) {
            assertEquals("The maximum number of players is 7", e.getMessage());
        }
    }

    @Test
    void startTheGame() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        game.addPlayer(new Player("Antoine"));
        game.addPlayer(new Player("Salma"));
        game.addPlayer(new Player("Myriam"));
        game.addPlayer(new Player("Jean-Marie"));
        game.start();
        assertTrue(game.isStarted());
    }

    @Test
    void startTheGameWithNotEnoughPlayers() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        try {
            game.start();
        } catch (RulesViolationException e) {
            assertEquals("The minimum number of players is 3", e.getMessage());
        }
        assertFalse(game.isStarted());
    }

    @Test
    void addAPlayerAfterTheGameStarts() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        game.addPlayer(new Player("Antoine"));
        game.start();
        try {
            game.addPlayer(new Player("Jean-Marie"));
        } catch (IllegalStateException e) {
            assertEquals("The game is already started", e.getMessage());
        }
    }

    @Test
    void startTheGameTwoTimes() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        game.addPlayer(new Player("Antoine"));
        game.start();
        try {
            game.start();
        } catch (IllegalStateException e) {
            assertEquals("The game is already started", e.getMessage());
        }
    }

    @Test
    void addAPlayerWithANameAlreadyUsed() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        try {
            game.addPlayer(new Player("François"));

        } catch (IllegalArgumentException e) {
            assertEquals("A player with the same name is already in the game", e.getMessage());
        }
    }

    @Test
    void handOutTheWonderBoards() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();

        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        List<WonderBoard> wonderBoards = wonderBoardFactory.getRandoms();
        game.handOutWonderBoards(wonderBoards);
        assertNotNull(francois.getWonderBoard());
        assertNotNull(louise.getWonderBoard());
        assertNotNull(antoine.getWonderBoard());
        assertEquals(4, wonderBoards.size());
    }

    @Test
    void handOutNotEnoughWonderBoards() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();

        List<WonderBoard> wonderBoards = new ArrayList<>();
        try {
            game.handOutWonderBoards(wonderBoards);
        } catch (IllegalArgumentException e) {
            assertEquals("They are not enough wonder boards", e.getMessage());
        }
    }

    @Test
    void handOutTheCoins() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();

        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        List<WonderBoard> wonderBoards = wonderBoardFactory.getRandoms();
        game.handOutWonderBoards(wonderBoards);
        game.handOutCoins(3);
        assertEquals(3, francois.getWonderBoard().getCoins());
        assertEquals(3, louise.getWonderBoard().getCoins());
        assertEquals(3, antoine.getWonderBoard().getCoins());
    }

    @Test
    void handOutTheCards() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        game.handOutCards(new DeckAgeI(3));
        assertEquals(7, francois.getHand().getCards().size());
        assertEquals(7, louise.getHand().getCards().size());
        assertEquals(7, antoine.getHand().getCards().size());
    }

    @Test
    void checkIfAllPlayersHaveChosenACard() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        game.handOutCards(new DeckAgeI(3));
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        assertTrue(game.allPlayersHaveChoosenACard());
    }
}
