package model.cards;

import model.Age;

import static model.cards.CardType.*;

public class DeckAgeI extends Deck {


    public DeckAgeI(int playerCount) {
        super(Age.I, playerCount);
    }

    @Override
    protected void build() {
        Card lumberYard = createCard(RAW_MATERIAL, "lumber yard", 4);
        add(lumberYard, 2);

        Card stonePit = createCard(RAW_MATERIAL, "stone pit", 5);
        add(stonePit, 2);

        Card clayPool = createCard(RAW_MATERIAL, "clay pool", 3);
        add(clayPool, 2);

        Card oreVein = createCard(RAW_MATERIAL, "ore vein", 3);
        add(oreVein, 2);

        Card treeFarm = createCard(RAW_MATERIAL, "tree farm", 3);
        add(treeFarm, 2);

        Card excavation = createCard(RAW_MATERIAL, "excavation", 3);
        add(excavation, 2);

        Card clayPit = createCard(RAW_MATERIAL, "clay pit", 3);
        add(clayPit, 2);

        Card timberYard = createCard(RAW_MATERIAL, "timber yard", 3);
        add(timberYard, 2);

        Card forestCave = createCard(RAW_MATERIAL, "forest cave", 3);
        add(forestCave, 2);

        Card mine = createCard(RAW_MATERIAL, "mine", 3);
        add(mine, 2);

        Card loom = createCard(MANUFACTURED_GOOD, "loom", 3);
        add(loom, 2);

        Card glassworks = createCard(MANUFACTURED_GOOD, "glassworks", 3);
        add(glassworks, 2);

        Card press = createCard(MANUFACTURED_GOOD, "press", 3);
        add(press, 2);

        Card panwshop = createCard(CIVILIAN_STRUCTURE, "pawnshop", 3);
        add(panwshop, 2);

        Card baths = createCard(CIVILIAN_STRUCTURE, "baths", 3);
        add(baths, 2);

        Card altar = createCard(CIVILIAN_STRUCTURE, "altar", 3);
        add(altar, 2);

        Card theater = createCard(CIVILIAN_STRUCTURE, "theater", 3);
        add(theater, 2);

        Card tavern = createCard(COMMERCIAL_STRUCTURE, "tavern", 3);
        add(tavern, 2);

        Card eastTradingPost = createCard(COMMERCIAL_STRUCTURE, "east trading post", 3);
        add(eastTradingPost);

        Card westTradingPost = createCard(COMMERCIAL_STRUCTURE, "west trading post", 3);
        add(westTradingPost);

        Card marketplace = createCard(COMMERCIAL_STRUCTURE, "marketplace", 3);
        add(marketplace, 2);

        Card stockade = createCard(MILITARY_STRUCTURE, "stockade", 3);
        add(stockade, 2);

        Card barracks = createCard(MILITARY_STRUCTURE, "barracks", 3);
        add(barracks, 2);

        Card guardTower = createCard(MILITARY_STRUCTURE, "guard tower", 3);
        add(guardTower, 2);

        Card apothecary = createCard(SCIENTIFIC_STRUCTURE, "apothecary", 3);
        add(apothecary, 2);

        Card workshop = createCard(SCIENTIFIC_STRUCTURE, "workshop", 3);
        add(workshop, 2);

        Card scriptorium = createCard(SCIENTIFIC_STRUCTURE, "scriptorium", 3);
        add(scriptorium, 2);
    }
}
