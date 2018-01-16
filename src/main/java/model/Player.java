package model;

import model.wonderboards.WonderBoard;

public class Player {

    private String name;

    private WonderBoard wonderBoard;

    public Player(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The player's name cannot be null or empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWonderBoard(WonderBoard wonderBoard) {
        this.wonderBoard = wonderBoard;
    }

    public WonderBoard getWonderBoard() {
        return wonderBoard;
    }
}
