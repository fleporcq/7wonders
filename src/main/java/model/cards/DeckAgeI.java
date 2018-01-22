package model.cards;

public class DeckAgeI extends Deck {

    public DeckAgeI(int playerNumber) {
        add(CardType.RAW_MATERIAL, "lumber yard");
        add(CardType.RAW_MATERIAL, "stone pit");
        add(CardType.RAW_MATERIAL, "clay pool");
        add(CardType.RAW_MATERIAL, "ore vein");
        add(CardType.RAW_MATERIAL, "tree farm");
        add(CardType.RAW_MATERIAL, "excavation");
        add(CardType.RAW_MATERIAL, "clay pit");
        add(CardType.RAW_MATERIAL, "timber yard");
        add(CardType.RAW_MATERIAL, "forest cave");
        add(CardType.RAW_MATERIAL, "mine");
        add(CardType.MANUFACTURED_GOOD, "loom");
        add(CardType.MANUFACTURED_GOOD, "glassworks");
        add(CardType.MANUFACTURED_GOOD, "press");
        add(CardType.CIVILIAN_STRUCTURE, "pawnshop");
        add(CardType.CIVILIAN_STRUCTURE, "baths");
        add(CardType.CIVILIAN_STRUCTURE, "altar");
        add(CardType.CIVILIAN_STRUCTURE, "theater");
        add(CardType.COMMERCIAL_STRUCTURE, "tavern");
        add(CardType.COMMERCIAL_STRUCTURE, "east trading post");
        add(CardType.COMMERCIAL_STRUCTURE, "west trading post");
        add(CardType.COMMERCIAL_STRUCTURE, "marketplace");
        add(CardType.MILITARY_STRUCTURE, "stockade");
        add(CardType.MILITARY_STRUCTURE, "barracks");
        add(CardType.MILITARY_STRUCTURE, "guard tower");
        add(CardType.SCIENTIFIC_STRUCTURE, "apothecary");
        add(CardType.SCIENTIFIC_STRUCTURE, "workshop");
        add(CardType.SCIENTIFIC_STRUCTURE, "scriptorium");
    }
}
