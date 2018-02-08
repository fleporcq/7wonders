import model.*;
import model.cards.DeckAgeI;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Resource.*;
import static model.wonderboards.City.*;
import static model.wonderboards.Side.A;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests implements DataTestsFactory {

    @Test
    void createAPlayerWithAnEmptyName() {
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
    void chooseACard() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        assertEquals(7, francois.getHand().getCards().size());
        francois.choose(francois.getHand().get("lumber yard"));
        assertTrue(francois.hasChosenACard());
        assertEquals(6, francois.getHand().getCards().size());
    }

    @Test
    void cancelHisChoice() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        francois.choose(francois.getHand().get("lumber yard"));
        louise.choose(louise.getHand().get("stone pit"));
        francois.cancelChoice();
    }

    @Test
    void sellACard() {
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
        assertEquals(1, game.getDiscarding().size());
    }

    @Test
    void sellACardAndChooseACard() {
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
    void getNeighborsOfAPlayer() {
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
    void payWithHisResources() {
        Player francois = new Player("François");
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(RHODES, A);
        francois.handOutWonderBoard(wonderBoard);
        wonderBoard.addCoins(3);
        assertTrue(francois.pay(ORE));
        assertFalse(francois.pay(WOOD));
        wonderBoard.addResource(WOOD);
        assertTrue(francois.pay(ORE, WOOD));
        assertFalse(francois.pay(ORE, ORE, WOOD));
        assertFalse(francois.pay(ORE, WOOD, WOOD));
    }

    @Test
    void payWithNeighborsResources() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        francois.handOutWonderBoard(wonderBoardFactory.get(RHODES, A));
        louise.handOutWonderBoard(wonderBoardFactory.get(BABYLON, A));
        antoine.handOutWonderBoard(wonderBoardFactory.get(OLYMPIA, A));
        game.handOutCoins(3);
        assertTrue(francois.validatePayment(ORE, new Purchase(WOOD, LEFT), new Purchase(CLAY, RIGHT)));
        assertFalse(francois.validatePayment(ORE, new Purchase(CLAY, LEFT), new Purchase(WOOD, RIGHT)));
    }

    @Test
    void payWithCoins() {
        Player francois = new Player("François");
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(RHODES, A);
        francois.handOutWonderBoard(wonderBoard);
        assertFalse(francois.pay(new Coin(1)));
        wonderBoard.addCoins(3);
        assertTrue(francois.pay(new Coin(1)));
        assertTrue(francois.pay(new Coin(2)));
        assertFalse(francois.pay(new Coin(1)));
        assertEquals(0, wonderBoard.getCoins());
    }

    @Test
    void buildAFreeCard() {
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
    void buildAFreeCardAndChooseACard() {
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
    void buildACardWithHisResource() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        francois.handOutWonderBoard(wonderBoardFactory.get(GIZAH, A));
        louise.handOutWonderBoard(wonderBoardFactory.get(BABYLON, A));
        antoine.handOutWonderBoard(wonderBoardFactory.get(OLYMPIA, A));
        game.handOutCards(new DeckAgeI(3));
        game.handOutCoins(3);
        francois.choose(francois.getHand().get("baths"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        try {
            francois.build(STONE);
        } catch (RulesViolationException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void buildACardWithACoin() {
        Game game = startATestGame("François", "Louise", "Antoine");
        Player francois = game.getPlayer("François");
        Player louise = game.getPlayer("Louise");
        Player antoine = game.getPlayer("Antoine");
        francois.choose(francois.getHand().get("stockade"));
        louise.choose(louise.getHand().get("clay pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        try {
            louise.build(new Coin(1));
        } catch (RulesViolationException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void buildACardWithAPurchase() {
        Game game = new Game();
        Player francois = new Player("François");
        Player louise = new Player("Louise");
        Player antoine = new Player("Antoine");
        game.addPlayer(francois);
        game.addPlayer(louise);
        game.addPlayer(antoine);
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        francois.handOutWonderBoard(wonderBoardFactory.get(RHODES, A));
        louise.handOutWonderBoard(wonderBoardFactory.get(BABYLON, A));
        antoine.handOutWonderBoard(wonderBoardFactory.get(OLYMPIA, A));
        game.handOutCards(new DeckAgeI(3));
        game.handOutCoins(3);
        francois.choose(francois.getHand().get("stockade"));
        louise.choose(louise.getHand().get("stone pit"));
        antoine.choose(antoine.getHand().get("clay pool"));
        try {
            francois.build(new Purchase(WOOD, LEFT));
        } catch (RulesViolationException e) {
            fail(e.getMessage());
        }
    }

}
