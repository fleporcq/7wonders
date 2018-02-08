package model.cards;

import model.Age;
import model.Coin;
import model.bonuses.Discount;
import model.bonuses.MultiResource;
import model.bonuses.Shield;
import model.bonuses.VictoryPoint;

import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Resource.*;
import static model.bonuses.ScientificSymbol.*;
import static model.cards.CardType.*;

public class DeckAgeI extends Deck {

    public DeckAgeI(int playerCount) {
        super(Age.I, playerCount);
    }

    @Override
    protected void build() {
        Card lumberYard = createCard(RAW_MATERIAL, "lumber yard");
        lumberYard.addBonuses(WOOD);
        add(lumberYard, 3, 4);

        Card stonePit = createCard(RAW_MATERIAL, "stone pit");
        stonePit.addBonuses(STONE);
        add(stonePit, 3, 5);

        Card clayPool = createCard(RAW_MATERIAL, "clay pool");
        clayPool.addBonuses(CLAY);
        add(clayPool, 3, 5);

        Card oreVein = createCard(RAW_MATERIAL, "ore vein");
        oreVein.addBonuses(ORE);
        add(oreVein, 3, 4);

        Card treeFarm = createCard(RAW_MATERIAL, "tree farm");
        treeFarm.addCosts(new Coin(1));
        treeFarm.addBonuses(new MultiResource(WOOD, CLAY));
        add(treeFarm, 6);

        Card excavation = createCard(RAW_MATERIAL, "excavation");
        excavation.addCosts(new Coin(1));
        excavation.addBonuses(new MultiResource(STONE, CLAY));
        add(excavation, 4);

        Card clayPit = createCard(RAW_MATERIAL, "clay pit");
        clayPit.addCosts(new Coin(1));
        clayPit.addBonuses(new MultiResource(CLAY, ORE));
        add(clayPit, 3);

        Card timberYard = createCard(RAW_MATERIAL, "timber yard");
        timberYard.addCosts(new Coin(1));
        timberYard.addBonuses(new MultiResource(STONE, WOOD));
        add(timberYard, 3);

        Card forestCave = createCard(RAW_MATERIAL, "forest cave");
        forestCave.addCosts(new Coin(1));
        forestCave.addBonuses(new MultiResource(WOOD, ORE));
        add(forestCave, 5);

        Card mine = createCard(RAW_MATERIAL, "mine");
        mine.addCosts(new Coin(1));
        mine.addBonuses(new MultiResource(ORE, STONE));
        add(mine, 6);

        Card loom = createCard(MANUFACTURED_GOOD, "loom");
        loom.addBonuses(LOOM);
        add(loom, 3, 6);

        Card glassworks = createCard(MANUFACTURED_GOOD, "glassworks");
        glassworks.addBonuses(GLASS);
        add(glassworks, 3, 6);

        Card press = createCard(MANUFACTURED_GOOD, "press");
        press.addBonuses(PAPYRUS);
        add(press, 3, 6);

        Card panwshop = createCard(CIVILIAN_STRUCTURE, "pawnshop");
        panwshop.addBonuses(new VictoryPoint(3));
        add(panwshop, 4, 7);

        Card baths = createCard(CIVILIAN_STRUCTURE, "baths");
        baths.addCosts(STONE);
        baths.addBonuses(new VictoryPoint(3));
        add(baths, 3, 7);

        Card altar = createCard(CIVILIAN_STRUCTURE, "altar");
        altar.addBonuses(new VictoryPoint(2));
        add(altar, 3, 5);

        Card theater = createCard(CIVILIAN_STRUCTURE, "theater");
        theater.addBonuses(new VictoryPoint(2));
        add(theater, 3, 6);

        Card tavern = createCard(COMMERCIAL_STRUCTURE, "tavern");
        tavern.addBonuses(new Coin(5));
        add(tavern, 4, 5, 7);

        Card eastTradingPost = createCard(COMMERCIAL_STRUCTURE, "east trading post");
        eastTradingPost.addBonuses(new Discount(RIGHT, 1, CLAY, STONE, WOOD, ORE));
        add(eastTradingPost, 3, 7);

        Card westTradingPost = createCard(COMMERCIAL_STRUCTURE, "west trading post");
        westTradingPost.addBonuses(new Discount(LEFT, 1, CLAY, STONE, WOOD, ORE));
        add(westTradingPost, 3, 7);

        Card marketplace = createCard(COMMERCIAL_STRUCTURE, "marketplace");
        marketplace.addBonuses(
                new Discount(LEFT, 1, GLASS, LOOM, PAPYRUS),
                new Discount(RIGHT, 1, GLASS, LOOM, PAPYRUS)
        );
        add(marketplace, 3, 6);

        Card stockade = createCard(MILITARY_STRUCTURE, "stockade");
        stockade.addCosts(WOOD);
        stockade.addBonuses(new Shield(1));
        add(stockade, 3, 7);

        Card barracks = createCard(MILITARY_STRUCTURE, "barracks");
        barracks.addCosts(ORE);
        barracks.addBonuses(new Shield(1));
        add(barracks, 3, 5);

        Card guardTower = createCard(MILITARY_STRUCTURE, "guard tower");
        guardTower.addCosts(CLAY);
        guardTower.addBonuses(new Shield(1));
        add(guardTower, 3, 4);

        Card apothecary = createCard(SCIENTIFIC_STRUCTURE, "apothecary");
        apothecary.addCosts(LOOM);
        apothecary.addBonuses(COMPASS);
        add(apothecary, 3, 5);

        Card workshop = createCard(SCIENTIFIC_STRUCTURE, "workshop");
        workshop.addCosts(GLASS);
        workshop.addBonuses(WHEEL);
        add(workshop, 3, 7);

        Card scriptorium = createCard(SCIENTIFIC_STRUCTURE, "scriptorium");
        scriptorium.addCosts(PAPYRUS);
        scriptorium.addBonuses(TABLET);
        add(scriptorium, 3, 4);
    }
}
