import model.Coin;
import model.wonderboards.City;
import model.wonderboards.Side;
import model.wonderboards.WonderBoard;
import model.wonderboards.WonderBoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTests {
    @Test
    void apply() {
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        WonderBoard wonderBoard = wonderBoardFactory.get(City.RHODES, Side.A);
        Coin coin = new Coin();
        coin.apply(wonderBoard);
        coin.apply(wonderBoard);
        coin.apply(wonderBoard);
        assertEquals(3, wonderBoard.getCoins());
    }
}
