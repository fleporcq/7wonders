package model.cards;

import model.Age;
import model.bonus.Bonus;

public class AgeICard extends Card {
    public AgeICard(String name, Bonus bonus, int minPlayers) {
        super(Age.I, name, bonus, minPlayers);
    }
}
