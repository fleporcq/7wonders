import model.resources.ResourceType;
import model.wonderboards.City;
import model.wonderboards.Side;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WonderBoardTests {

    @Test
    void testGetBonus() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.getWonderBoard(City.EPHESOS, Side.A);
        assertTrue(wonderBoard.has(ResourceType.PAPYRUS));
    }
}
