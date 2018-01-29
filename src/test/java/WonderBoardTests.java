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
    void testGetBonus() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        assertTrue(wonderBoard.has(Resource.PAPYRUS));
    }

    @Test
    void testAddCoins() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        wonderBoard.addCoins(3);
        assertEquals(3, wonderBoard.getCoins());
    }

    @Test
    void testRemoveCoins() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.EPHESOS, Side.A);
        wonderBoard.addCoins(3);
        wonderBoard.removeCoins(3);
        assertEquals(0, wonderBoard.getCoins());
    }
}
