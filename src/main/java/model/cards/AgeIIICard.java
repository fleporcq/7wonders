package model.cards;

import model.Age;
import model.bonus.Bonus;

public class AgeIIICard extends Card {
    public AgeIIICard(String name, Bonus bonus, int minPlayers) {
        super(Age.III, name, bonus, minPlayers);
    }
}
