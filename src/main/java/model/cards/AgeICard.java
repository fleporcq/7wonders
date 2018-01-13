package main.java.model.cards;

import main.java.model.Age;
import main.java.model.bonus.Bonus;

public class AgeICard extends Card {
    public AgeICard(String name, Bonus bonus, int minPlayers) {
        super(Age.I, name, bonus, minPlayers);
    }
}
