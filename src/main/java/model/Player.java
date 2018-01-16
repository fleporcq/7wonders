package model;

public class Player {

    private String name;

    public Player(String name) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The player's name cannot be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
