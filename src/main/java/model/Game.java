package model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int PLAYER_MIN = 3;
    private static final int PLAYER_MAX = 7;

    private List<Player> players = new ArrayList<>();

    private boolean started;

    public void addPlayer(Player player) throws RulesViolationException {
        if (started)
            throw new IllegalStateException("The game is already started");
        if (players.size() == PLAYER_MAX)
            throw new RulesViolationException("The maximum number of players is " + PLAYER_MAX);
        if (getPlayer(player.getName()) != null)
            throw new IllegalArgumentException("A player with the same name is already in the game");
        players.add(player);
    }

    public Player getPlayer(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public int getPlayerCount() {
        return players.size();
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
}
