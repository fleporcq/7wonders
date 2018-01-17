import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

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
}
