package model.cards;

import model.Age;

import static model.cards.CardType.*;

public class DeckAgeI extends Deck {


    public DeckAgeI(int playerCount) {
        super(Age.I, playerCount);
    }

    @Override
    protected void build() {
        Card lumberYard = createCard(RAW_MATERIAL, "lumber yard");
        add(lumberYard, 3, 4);

        Card stonePit = createCard(RAW_MATERIAL, "stone pit");
        add(stonePit, 3, 5);

        Card clayPool = createCard(RAW_MATERIAL, "clay pool");
        add(clayPool, 3, 5);

        Card oreVein = createCard(RAW_MATERIAL, "ore vein");
        add(oreVein, 3, 4);

        Card treeFarm = createCard(RAW_MATERIAL, "tree farm");
        add(treeFarm, 6);

        Card excavation = createCard(RAW_MATERIAL, "excavation");
        add(excavation, 4);

        Card clayPit = createCard(RAW_MATERIAL, "clay pit");
        add(clayPit, 3);

        Card timberYard = createCard(RAW_MATERIAL, "timber yard");
        add(timberYard, 3);

        Card forestCave = createCard(RAW_MATERIAL, "forest cave");
        add(forestCave, 5);

        Card mine = createCard(RAW_MATERIAL, "mine");
        add(mine, 6);

        Card loom = createCard(MANUFACTURED_GOOD, "loom");
        add(loom, 3, 6);

        Card glassworks = createCard(MANUFACTURED_GOOD, "glassworks");
        add(glassworks, 3, 6);

        Card press = createCard(MANUFACTURED_GOOD, "press");
        add(press, 3, 6);

        Card panwshop = createCard(CIVILIAN_STRUCTURE, "pawnshop");
        add(panwshop, 4, 7);

        Card baths = createCard(CIVILIAN_STRUCTURE, "baths");
        add(baths, 3, 7);

        Card altar = createCard(CIVILIAN_STRUCTURE, "altar");
        add(altar, 3, 5);

        Card theater = createCard(CIVILIAN_STRUCTURE, "theater");
        add(theater, 3, 6);

        Card tavern = createCard(COMMERCIAL_STRUCTURE, "tavern");
        add(tavern, 4, 5, 7);

        Card eastTradingPost = createCard(COMMERCIAL_STRUCTURE, "east trading post");
        add(eastTradingPost, 3, 7);

        Card westTradingPost = createCard(COMMERCIAL_STRUCTURE, "west trading post");
        add(westTradingPost, 3, 7);

        Card marketplace = createCard(COMMERCIAL_STRUCTURE, "marketplace");
        add(marketplace, 3, 6);

        Card stockade = createCard(MILITARY_STRUCTURE, "stockade");
        add(stockade, 3, 7);

        Card barracks = createCard(MILITARY_STRUCTURE, "barracks");
        add(barracks, 3, 5);

        Card guardTower = createCard(MILITARY_STRUCTURE, "guard tower");
        add(guardTower, 3, 4);

        Card apothecary = createCard(SCIENTIFIC_STRUCTURE, "apothecary");
        add(apothecary, 3, 5);

        Card workshop = createCard(SCIENTIFIC_STRUCTURE, "workshop");
        add(workshop, 3, 7);

        Card scriptorium = createCard(SCIENTIFIC_STRUCTURE, "scriptorium");
        add(scriptorium, 3, 4);
    }
}
