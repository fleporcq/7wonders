package model;

import model.cards.Card;
import model.cards.Deck;
import model.wonderboards.WonderBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public static final int PLAYER_MIN = 3;
    public static final int PLAYER_MAX = 7;
    public static final int CARD_DISCARDING_AMOUT = 3;

    private List<Player> players = new ArrayList<>();

    private Discarding discarding = new Discarding();

    private boolean started;

    public void addPlayer(Player player) throws RulesViolationException {
        if (started)
            throw new IllegalStateException("The game is already started");
        if (players.size() == PLAYER_MAX)
            throw new RulesViolationException("The maximum number of players is " + PLAYER_MAX);
        if (getPlayer(player.getName()) != null)
            throw new IllegalArgumentException("A player with the same name is already in the game");
        player.setGame(this);
        players.add(player);
    }

    public Player getPlayer(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public void discard(Card card) {
        discarding.add(card);
    }

    public void start() throws RulesViolationException {
        if (started)
            throw new IllegalStateException("The game is already started");
        if (players.size() < PLAYER_MIN)
            throw new RulesViolationException("The minimum number of players is " + PLAYER_MIN);
        started = true;
    }

    public boolean isStarted() {
        return started;
    }

    public void handOutWonderBoards(List<WonderBoard> wonderBoards) {
        errorIfNotStarted();
        if (wonderBoards.size() < players.size())
            throw new IllegalArgumentException("They are not enough wonder boards");
        Collections.shuffle(wonderBoards);
        for (Player player : players) {
            player.setWonderBoard(wonderBoards.remove(0));
        }
    }

    public void handOutCoins(int amount) {
        errorIfNotStarted();
        for (Player player : players) {
            WonderBoard wonderBoard = player.getWonderBoard();
            wonderBoard.addCoins(amount);
        }
    }

    public void handOutCards(Deck deck) {
        errorIfNotStarted();
        Player player = null;
        for (Card card : deck.getCards()) {
            player = nextPlayer(player);
            player.getHand().add(card);
        }
    }

    private Player nextPlayer(Player current) {
        Integer index = current == null ? null : players.indexOf(current);
        int next;
        if (index == null)
            next = 0;
        else
            next = index < players.size() - 1 ? index + 1 : 0;
        return players.get(next);
    }

    public boolean allPlayersHaveChoosenACard() {
        errorIfNotStarted();
        for (Player player : players) {
            if (!player.hasChosenACard())
                return false;
        }
        return true;
    }

    private void errorIfNotStarted() {
        if (!started)
            throw new IllegalStateException("The game is not yet started");
    }

}
