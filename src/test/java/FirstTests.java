import model.Game;
import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTests {
    @Test
    void testNewGame() {
        Game game = new Game();
        game.addPlayer(new Player("François"));
        assertEquals("François",game.getPlayers().get(0).getName());
    }
}
