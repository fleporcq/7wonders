import model.Game;
import model.Player;
import model.RulesViolationException;
import org.junit.jupiter.api.Test;

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

}
