import model.Buy;
import model.Game;
import model.Player;
import model.RulesViolationException;
import model.cards.DeckAgeI;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import static model.Direction.LEFT;
import static model.Resource.WOOD;
import static model.wonderboards.City.*;
import static model.wonderboards.Side.A;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests implements DataTestsFactory {

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
    void testAPlayerChoosesACard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        assertEquals(7, francois.getHand().getCards().size());
        francois.choose(francois.getHand().get("lumber yard"));
        assertTrue(francois.hasChosenACard());
        assertEquals(6, francois.getHand().getCards().size());
    }

    @Test
    void testAPlayerCancelsHisChoice() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        francois.cancelChoice();
    }

    @Test
    void testAPlayerSellsACard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        assertEquals(3, francois.getWonderBoard().getCoins());
        francois.sell();
        assertEquals(6, francois.getWonderBoard().getCoins());
        assertFalse(francois.hasChosenACard());
    }

    @Test
    void testAPlayerSellsACardAndChooseACard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        francois.sell();
        try {
            francois.choose(francois.getHand().get("ore vein"));
        } catch (RulesViolationException e) {
            assertEquals("You have already played for this turn", e.getMessage());
        }
    }

    @Test
    void testAPlayerBuildsAFreeCard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        francois.build();
        assertFalse(francois.hasChosenACard());
        assertEquals(1, francois.getWonderBoard().getBuiltCards().size());
    }

    @Test
    void testAPlayerBuildsAFreeCardAndChooseACard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        francois.build();
        try {
            francois.choose(francois.getHand().get("ore vein"));
        } catch (RulesViolationException e) {
            assertEquals("You have already played for this turn", e.getMessage());
        }
    }

    @Test
    void testGetNeighborsOfAPlayer() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");

        assertEquals("Antoine", francois.getLeftNeighbor().getName());
        assertEquals("Louise", francois.getRightNeighbor().getName());

        assertEquals("François", louise.getLeftNeighbor().getName());
        assertEquals("Antoine", louise.getRightNeighbor().getName());

        assertEquals("Louise", antoine.getLeftNeighbor().getName());
        assertEquals("François", antoine.getRightNeighbor().getName());
    }

    @Test
    void testAPlayerBuildsACardWithNeighborsResources() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        francois.setWonderBoard(wonderBoardFactory.get(RHODES, A));
        louise.setWonderBoard(wonderBoardFactory.get(BABYLON, A));
        antoine.setWonderBoard(wonderBoardFactory.get(OLYMPIA, A));
        game.handOutCards(new DeckAgeI(3));

        francois.choose(francois.getHand().get("stockade"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        francois.build(new Buy(WOOD, LEFT));
        // François
        // Rhodes
        // lumber yard,ore vein,loom,baths,east trading post,stockade,apothecary


        // Louise
        // Babylon
        // stone pit,clay pit,glassworks,altar,west trading post,barracks,workshop

        // Antoine
        // Olympia
        // clay pool,timber yard,press,theater,marketplace,guard tower,scriptorium

    }

}
