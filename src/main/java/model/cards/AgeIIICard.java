package main.java.model.cards;

import main.java.model.Age;
import main.java.model.bonus.Bonus;

public class AgeIIICard extends Card {
    public AgeIIICard(String name, Bonus bonus, int minPlayers) {
        super(Age.III, name, bonus, minPlayers);
    }
}
