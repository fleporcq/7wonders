import model.Game;
import model.Player;
import model.RulesViolationException;
import model.wonderboards.Side;
import model.wonderboards.WonderBoard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    @Test
    void testAddPlayersToGame() throws RulesViolationException {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        game.addPlayer(new Player("Louise"));
        game.addPlayer(new Player("Antoine"));
        game.addPlayer(new Player("Salma"));
        assertEquals("François", game.getPlayer("François").getName());
        assertEquals(4, game.getPlayerCount());
    }

    @Test
    void testAddTooMuchPlayersToGame() {
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
    void testStartTheGame() throws RulesViolationException {
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
    void testStartTheGameWithNotEnoughPlayer() throws RulesViolationException {
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
    void testAddPlayerAfterTheGameStarts() throws RulesViolationException {
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
    void testStartTheGameTwoTimes() throws RulesViolationException {
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
    void testAddPlayerWithSameName() throws RulesViolationException {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        try {
            game.addPlayer(new Player("François"));

        } catch (IllegalArgumentException e) {
            assertEquals("A player with the same name is already in the game", e.getMessage());
        }
    }

    @Test
    void testHandOutTheWonderBoards() throws RulesViolationException {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        List<WonderBoard> wonderBoards = new ArrayList<>();
        wonderBoards.add(new WonderBoard("Rhodes", Side.A));
        wonderBoards.add(new WonderBoard("Alexandria", Side.A));
        wonderBoards.add(new WonderBoard("Ephesos", Side.B));
        wonderBoards.add(new WonderBoard("Babylon", Side.B));
        game.handOutWonderBoards(wonderBoards);
        assertNotNull(francois.getWonderBoard());
        assertNotNull(louise.getWonderBoard());
        assertNotNull(antoine.getWonderBoard());
        assertEquals(1, wonderBoards.size());
    }
}
