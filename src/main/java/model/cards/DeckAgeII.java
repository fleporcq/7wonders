package model.cards;

import model.Age;
import model.Coin;
import model.bonuses.CardBonus;
import model.bonuses.MultiResource;
import model.bonuses.Shield;
import model.bonuses.VictoryPoint;

import static model.Direction.*;
import static model.Resource.*;
import static model.bonuses.ScientificSymbol.*;
import static model.cards.CardType.*;

public class DeckAgeII extends Deck {

    public DeckAgeII(int playerCount) {
        super(Age.II, playerCount);
    }

    @Override
    protected void build() {
        Card sawmill = createCard(RAW_MATERIAL, "sawmill");
        sawmill.addCosts(new Coin(1));
        sawmill.addBonuses(WOOD, WOOD);
        add(sawmill, 3, 4);

        Card quarry = createCard(RAW_MATERIAL, "quarry");
        quarry.addCosts(new Coin(1));
        quarry.addBonuses(STONE, STONE);
        add(quarry, 3, 4);

        Card brickyard = createCard(RAW_MATERIAL, "brickyard");
        brickyard.addCosts(new Coin(1));
        brickyard.addBonuses(CLAY, CLAY);
        add(brickyard, 3, 4);

        Card foundry = createCard(RAW_MATERIAL, "foundry");
        foundry.addCosts(new Coin(1));
        foundry.addBonuses(ORE, ORE);
        add(foundry, 3, 4);

        Card loom = createCard(MANUFACTURED_GOOD, "loom");
        loom.addBonuses(LOOM);
        add(loom, 3, 5);

        Card glassworks = createCard(MANUFACTURED_GOOD, "glassworks");
        glassworks.addBonuses(GLASS);
        add(glassworks, 3, 5);

        Card press = createCard(MANUFACTURED_GOOD, "press");
        press.addBonuses(PAPYRUS);
        add(press, 3, 5);

        Card aqueduct = createCard(CIVILIAN_STRUCTURE, "aqueduct");
        aqueduct.addCosts(STONE, STONE, STONE);
        aqueduct.addBonuses(new VictoryPoint(5));
        add(aqueduct, 3, 7);

        Card temple = createCard(CIVILIAN_STRUCTURE, "temple");
        temple.addCosts(WOOD, CLAY, GLASS);
        temple.addBonuses(new VictoryPoint(3));
        add(temple, 3, 6);

        Card statue = createCard(CIVILIAN_STRUCTURE, "statue");
        statue.addCosts(ORE, ORE, WOOD);
        statue.addBonuses(new VictoryPoint(4));
        add(statue, 3, 7);

        Card courthouse = createCard(CIVILIAN_STRUCTURE, "courthouse");
        courthouse.addCosts(CLAY, CLAY, LOOM);
        courthouse.addBonuses(new VictoryPoint(4));
        add(courthouse, 3, 5);

        Card forum = createCard(COMMERCIAL_STRUCTURE, "forum");
        forum.addCosts(CLAY, CLAY);
        forum.addBonuses(new MultiResource(LOOM, GLASS, PAPYRUS));
        add(forum, 3, 6, 7);

        Card caravansery = createCard(COMMERCIAL_STRUCTURE, "caravansery");
        caravansery.addCosts(WOOD, WOOD);
        caravansery.addBonuses(new MultiResource(CLAY, STONE, ORE, WOOD));
        add(caravansery, 3, 5, 6);

        Card vineyard = createCard(COMMERCIAL_STRUCTURE, "vineyard");
        vineyard.addBonuses(
                new CardBonus(RAW_MATERIAL, 1, 0, LEFT),
                new CardBonus(RAW_MATERIAL, 1, 0, RIGHT),
                new CardBonus(RAW_MATERIAL, 1, 0, ME)
        );
        add(vineyard, 3, 6);

        Card bazar = createCard(COMMERCIAL_STRUCTURE, "bazar");
        bazar.addBonuses(
                new CardBonus(MANUFACTURED_GOOD, 2, 0, LEFT),
                new CardBonus(MANUFACTURED_GOOD, 2, 0, RIGHT),
                new CardBonus(MANUFACTURED_GOOD, 2, 0, ME)
        );
        add(bazar, 4, 7);

        Card walls = createCard(MILITARY_STRUCTURE, "walls");
        walls.addCosts(STONE, STONE, STONE);
        walls.addBonuses(new Shield(2));
        add(walls, 3, 7);

        Card trainingGround = createCard(MILITARY_STRUCTURE, "training ground");
        trainingGround.addCosts(ORE, ORE, WOOD);
        trainingGround.addBonuses(new Shield(2));
        add(trainingGround, 4, 6, 7);

        Card stables = createCard(MILITARY_STRUCTURE, "stables");
        stables.addCosts(ORE, CLAY, WOOD);
        stables.addBonuses(new Shield(2));
        add(stables, 3, 5);

        Card archeryRange = createCard(MILITARY_STRUCTURE, "archery range");
        archeryRange.addCosts(WOOD, WOOD, ORE);
        archeryRange.addBonuses(new Shield(2));
        add(archeryRange, 3, 6);

        Card dispensary = createCard(SCIENTIFIC_STRUCTURE, "dispensary");
        dispensary.addCosts(ORE, ORE, GLASS);
        dispensary.addBonuses(COMPASS);
        add(dispensary, 3, 4);

        Card laboratory = createCard(SCIENTIFIC_STRUCTURE, "laboratory");
        laboratory.addCosts(CLAY, CLAY, PAPYRUS);
        laboratory.addBonuses(WHEEL);
        add(laboratory, 3, 5);

        Card library = createCard(SCIENTIFIC_STRUCTURE, "library");
        library.addCosts(STONE, STONE, LOOM);
        library.addBonuses(TABLET);
        add(library, 3, 6);

        Card school = createCard(SCIENTIFIC_STRUCTURE, "school");
        school.addCosts(WOOD, PAPYRUS);
        school.addBonuses(TABLET);
        add(school, 3, 7);
    }
}
