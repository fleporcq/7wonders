import model.Game;
import model.Player;
import model.cards.DeckAgeI;
import model.wonderboards.WonderBoardFactory;

public interface DataTestsFactory {

    default Game startATestGame(String... playerNames) {
        Game game = new Game();
        for (int i = 0; i < playerNames.length; i++) {
            game.addPlayer(new Player(playerNames[i]));
        }
        game.start();
        WonderBoardFactory wonderBoardFactory = new WonderBoardFactory();
        game.handOutWonderBoards(wonderBoardFactory.getRandoms());
        // We don't shuffle the deck for the tests
        game.handOutCards(new DeckAgeI(playerNames.length));
        game.handOutCoins(3);
        return game;
    }

}
