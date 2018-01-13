package main.java.model.cards;

import main.java.model.Age;
import main.java.model.bonus.Bonus;

public class AgeIICard extends Card {
    public AgeIICard(String name, Bonus bonus, int minPlayers) {
        super(Age.II, name, bonus, minPlayers);
    }
}
