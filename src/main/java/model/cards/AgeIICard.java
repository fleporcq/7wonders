package model.cards;

import model.Age;
import model.bonus.Bonus;

public class AgeIICard extends Card {
    public AgeIICard(String name, Bonus bonus, int minPlayers) {
        super(Age.II, name, bonus, minPlayers);
    }
}
