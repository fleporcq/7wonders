package model.cards;

import model.Age;
import model.Coin;

import static model.Resource.*;
import static model.cards.CardType.*;

public class DeckAgeII extends Deck {

    public DeckAgeII(int playerCount) {
        super(Age.II, playerCount);
    }

    @Override
    protected void build() {
        Card sawmill = createCard(RAW_MATERIAL, "sawmill");
        sawmill.addCosts(new Coin(1));
        add(sawmill, 3, 4);

        Card quarry = createCard(RAW_MATERIAL, "quarry");
        quarry.addCosts(new Coin(1));
        add(quarry, 3, 4);

        Card brickyard = createCard(RAW_MATERIAL, "brickyard");
        brickyard.addCosts(new Coin(1));
        add(brickyard, 3, 4);

        Card foundry = createCard(RAW_MATERIAL, "foundry");
        foundry.addCosts(new Coin(1));
        add(foundry, 3, 4);

        Card loom = createCard(MANUFACTURED_GOOD, "loom");
        add(loom, 3, 5);

        Card glassworks = createCard(MANUFACTURED_GOOD, "glassworks");
        add(glassworks, 3, 5);

        Card press = createCard(MANUFACTURED_GOOD, "press");
        add(press, 3, 5);

        Card aqueduct = createCard(CIVILIAN_STRUCTURE, "aqueduct");
        aqueduct.addCosts(STONE, STONE, STONE);
        add(aqueduct, 3, 7);

        Card temple = createCard(CIVILIAN_STRUCTURE, "temple");
        temple.addCosts(WOOD, CLAY, GLASS);
        add(temple, 3, 6);

        Card statue = createCard(CIVILIAN_STRUCTURE, "statue");
        statue.addCosts(ORE, ORE, WOOD);
        add(statue, 3, 7);

        Card courthouse = createCard(CIVILIAN_STRUCTURE, "courthouse");
        courthouse.addCosts(CLAY, CLAY, LOOM);
        add(courthouse, 3, 5);

        Card forum = createCard(COMMERCIAL_STRUCTURE, "forum");
        forum.addCosts(CLAY, CLAY);
        add(forum, 3, 6, 7);

        Card caravansery = createCard(COMMERCIAL_STRUCTURE, "caravansery");
        caravansery.addCosts(WOOD, WOOD);
        add(caravansery, 3, 5, 6);

        Card vineyard = createCard(COMMERCIAL_STRUCTURE, "vineyard");
        add(vineyard, 3, 6);

        Card bazar = createCard(COMMERCIAL_STRUCTURE, "bazar");
        add(bazar, 4, 7);

        Card walls = createCard(MILITARY_STRUCTURE, "walls");
        walls.addCosts(STONE, STONE, STONE);
        add(walls, 3, 7);

        Card trainingGround = createCard(MILITARY_STRUCTURE, "training ground");
        trainingGround.addCosts(ORE, ORE, WOOD);
        add(trainingGround, 4, 6, 7);

        Card stables = createCard(MILITARY_STRUCTURE, "stables");
        stables.addCosts(ORE, CLAY, WOOD);
        add(stables, 3, 5);

        Card archeryRange = createCard(MILITARY_STRUCTURE, "archery range");
        archeryRange.addCosts(WOOD, WOOD, ORE);
        add(archeryRange, 3, 6);

        Card dispensary = createCard(SCIENTIFIC_STRUCTURE, "dispensary");
        dispensary.addCosts(ORE, ORE, GLASS);
        add(dispensary, 3, 4);

        Card laboratory = createCard(SCIENTIFIC_STRUCTURE, "laboratory");
        laboratory.addCosts(CLAY, CLAY, PAPYRUS);
        add(laboratory, 3, 5);

        Card library = createCard(SCIENTIFIC_STRUCTURE, "library");
        library.addCosts(STONE, STONE, LOOM);
        add(library, 3, 6);

        Card school = createCard(SCIENTIFIC_STRUCTURE, "school");
        school.addCosts(WOOD, PAPYRUS);
        add(school, 3, 7);
    }
}
