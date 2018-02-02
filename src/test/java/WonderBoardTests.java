import model.Resource;
import model.wonderboards.City;
import model.wonderboards.Side;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WonderBoardTests {

    @Test
    void createANewWonderBoard() {
        try {
            new WonderBoard(null, Side.A);
        } catch (IllegalArgumentException e) {
            assertEquals("The wonderboard's city cannot be null", e.getMessage());
        }
        try {
            new WonderBoard(City.RHODES, null);
        } catch (IllegalArgumentException e) {
            assertEquals("The wonderboard's side cannot be null", e.getMessage());
        }
    }

    @Test
    void testToString() {
        WonderBoard rhodes = new WonderBoard(City.RHODES, Side.A);
        assertEquals("RHODES A", rhodes.toString());
    }

    @Test
    void addCoins() {
        WonderBoard rhodes = new WonderBoard(City.RHODES, Side.A);
        rhodes.addCoins(3);
        rhodes.addCoins(2);
        assertEquals(5, rhodes.getCoins());
        try {
            rhodes.addCoins(0);
        } catch (IllegalArgumentException e) {
            assertEquals("The amount must be at least 1", e.getMessage());
        }
    }

    @Test
    void removeCoins() {
        WonderBoard rhodes = new WonderBoard(City.RHODES, Side.A);
        rhodes.addCoins(5);
        rhodes.removeCoins(2);
        assertEquals(3, rhodes.getCoins());
        try {
            rhodes.removeCoins(0);
        } catch (IllegalArgumentException e) {
            assertEquals("The amount must be at least 1", e.getMessage());
        }
    }

    @Test
    void getTheBonus() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        assertTrue(wonderBoard.has(Resource.PAPYRUS));
    }

    @Test
    void addSomeCoins() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        wonderBoard.addCoins(3);
        assertEquals(3, wonderBoard.getCoins());
    }

    @Test
    void removeSomeCoins() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        wonderBoard.addCoins(3);
        wonderBoard.removeCoins(3);
        assertEquals(0, wonderBoard.getCoins());
    }
}
