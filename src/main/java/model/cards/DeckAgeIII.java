package model.cards;

import model.Age;
import model.bonuses.*;

import static model.ConflictToken.MIN_ONE;
import static model.Direction.*;
import static model.Resource.*;
import static model.bonuses.ScientificSymbol.*;
import static model.cards.CardType.*;

public class DeckAgeIII extends Deck {

    public DeckAgeIII(int playerCount) {
        super(Age.III, playerCount);
    }

    @Override
    protected void build() {
        Card pantheon = createCard(CIVILIAN_STRUCTURE, "pantheon");
        pantheon.addCosts(CLAY, CLAY, ORE, PAPYRUS, LOOM, GLASS);
        pantheon.addBonuses(new VictoryPoint(7));
        add(pantheon, 3, 6);

        Card gardens = createCard(CIVILIAN_STRUCTURE, "gardens");
        gardens.addCosts(CLAY, CLAY, WOOD);
        gardens.addBonuses(new VictoryPoint(5));
        add(gardens, 3, 4);

        Card townHall = createCard(CIVILIAN_STRUCTURE, "town hall");
        townHall.addCosts(STONE, STONE, ORE, GLASS);
        townHall.addBonuses(new VictoryPoint(6));
        add(townHall, 3, 5, 6);

        Card palace = createCard(CIVILIAN_STRUCTURE, "palace");
        palace.addCosts(CLAY, WOOD, ORE, STONE, GLASS, PAPYRUS, LOOM);
        palace.addBonuses(new VictoryPoint(8));
        add(palace, 3, 7);

        Card senate = createCard(CIVILIAN_STRUCTURE, "senate");
        senate.addCosts(WOOD, WOOD, ORE, STONE);
        senate.addBonuses(new VictoryPoint(6));
        add(senate, 3, 5);

        Card haven = createCard(COMMERCIAL_STRUCTURE, "haven");
        haven.addCosts(ORE, WOOD, LOOM);
        haven.addBonuses(new CardBonus(RAW_MATERIAL, 1, 1, ME));
        add(haven, 3, 4);

        Card lighthouse = createCard(COMMERCIAL_STRUCTURE, "lighthouse");
        lighthouse.addCosts(STONE, GLASS);
        lighthouse.addBonuses(new CardBonus(COMMERCIAL_STRUCTURE, 1, 1, ME));
        add(lighthouse, 3, 6);

        Card chamberOfCommerce = createCard(COMMERCIAL_STRUCTURE, "chamber of commerce");
        chamberOfCommerce.addCosts(CLAY, CLAY, PAPYRUS);
        chamberOfCommerce.addBonuses(new CardBonus(MANUFACTURED_GOOD, 2, 2, ME));
        add(chamberOfCommerce, 4, 6);

        Card arena = createCard(COMMERCIAL_STRUCTURE, "arena");
        arena.addCosts(STONE, STONE, ORE);
        arena.addBonuses(new WonderBonus(3, 1, ME));
        add(arena, 3, 5, 7);

        Card fortifications = createCard(MILITARY_STRUCTURE, "fortifications");
        fortifications.addCosts(ORE, ORE, ORE, STONE);
        fortifications.addBonuses(new Shield(3));
        add(fortifications, 3, 7);

        Card circus = createCard(MILITARY_STRUCTURE, "circus");
        circus.addCosts(STONE, STONE, ORE);
        circus.addBonuses(new Shield(3));
        add(circus, 4, 5, 6);

        Card arsenal = createCard(MILITARY_STRUCTURE, "arsenal");
        arsenal.addCosts(ORE, WOOD, WOOD, LOOM);
        arsenal.addBonuses(new Shield(3));
        add(arsenal, 3, 4, 7);

        Card siegeWorkshop = createCard(MILITARY_STRUCTURE, "siege workshop");
        siegeWorkshop.addCosts(WOOD, CLAY, CLAY, CLAY);
        siegeWorkshop.addBonuses(new Shield(3));
        add(siegeWorkshop, 3, 5);

        Card lodge = createCard(SCIENTIFIC_STRUCTURE, "lodge");
        lodge.addCosts(CLAY, CLAY, LOOM, PAPYRUS);
        lodge.addBonuses(COMPASS);
        add(lodge, 3, 6);

        Card observatory = createCard(SCIENTIFIC_STRUCTURE, "observatory");
        observatory.addCosts(ORE, ORE, GLASS, LOOM);
        observatory.addBonuses(WHEEL);
        add(observatory, 3, 7);

        Card university = createCard(SCIENTIFIC_STRUCTURE, "university");
        university.addCosts(WOOD, WOOD, PAPYRUS, GLASS);
        university.addBonuses(TABLET);
        add(university, 3, 4);

        Card academy = createCard(SCIENTIFIC_STRUCTURE, "academy");
        academy.addCosts(STONE, STONE, STONE, GLASS);
        academy.addBonuses(COMPASS);
        add(academy, 3, 7);

        Card study = createCard(SCIENTIFIC_STRUCTURE, "study");
        study.addCosts(WOOD, PAPYRUS, LOOM);
        study.addBonuses(WHEEL);
        add(study, 3, 5);

        Card workersGuild = createCard(GUILD, "workers guild");
        workersGuild.addCosts(ORE, ORE, CLAY, STONE, WOOD);
        workersGuild.addBonuses(
                new CardBonus(RAW_MATERIAL, 0, 1, LEFT),
                new CardBonus(RAW_MATERIAL, 0, 1, RIGHT)
        );
        addGuild(workersGuild);

        Card craftmensGuild = createCard(GUILD, "craftmens guild");
        craftmensGuild.addCosts(ORE, ORE, STONE, STONE);
        craftmensGuild.addBonuses(
                new CardBonus(MANUFACTURED_GOOD, 0, 2, LEFT),
                new CardBonus(MANUFACTURED_GOOD, 0, 2, RIGHT)
        );
        addGuild(craftmensGuild);

        Card tradersGuild = createCard(GUILD, "traders guild");
        tradersGuild.addCosts(LOOM, PAPYRUS, GLASS);
        tradersGuild.addBonuses(
                new CardBonus(COMMERCIAL_STRUCTURE, 0, 1, LEFT),
                new CardBonus(COMMERCIAL_STRUCTURE, 0, 1, RIGHT)
        );
        addGuild(tradersGuild);

        Card philosophersGuild = createCard(GUILD, "philosophers guild");
        philosophersGuild.addCosts(CLAY, CLAY, CLAY, LOOM, PAPYRUS);
        philosophersGuild.addBonuses(
                new CardBonus(SCIENTIFIC_STRUCTURE, 0, 1, LEFT),
                new CardBonus(SCIENTIFIC_STRUCTURE, 0, 1, RIGHT)
        );
        addGuild(philosophersGuild);

        Card spyGuild = createCard(GUILD, "spy guild");
        spyGuild.addCosts(CLAY, CLAY, CLAY, GLASS);
        spyGuild.addBonuses(
                new CardBonus(MILITARY_STRUCTURE, 0, 1, LEFT),
                new CardBonus(MILITARY_STRUCTURE, 0, 1, RIGHT)
        );
        addGuild(spyGuild);

        Card strategyGuild = createCard(GUILD, "strategy guild");
        strategyGuild.addCosts(ORE, ORE, STONE, LOOM);
        strategyGuild.addBonuses(
                new ConflictTokenBonus(MIN_ONE, 0, 1, LEFT),
                new ConflictTokenBonus(MIN_ONE, 0, 1, RIGHT)
        );
        addGuild(strategyGuild);

        Card shipownersGuild = createCard(GUILD, "shipowners guild");
        shipownersGuild.addCosts(WOOD, WOOD, WOOD, PAPYRUS, GLASS);
        shipownersGuild.addBonuses(
                new CardBonus(RAW_MATERIAL, 0, 1, ME),
                new CardBonus(MANUFACTURED_GOOD, 0, 1, ME),
                new CardBonus(GUILD, 0, 1, ME)
        );
        addGuild(shipownersGuild);

        Card scientitsGuild = createCard(GUILD, "scientits guild");
        scientitsGuild.addCosts(WOOD, WOOD, ORE, ORE, PAPYRUS);
        scientitsGuild.addBonuses(new MultiScientificSymbol(COMPASS, WHEEL, TABLET));
        addGuild(scientitsGuild);

        Card magistratesGuild = createCard(GUILD, "magistrates guild");
        magistratesGuild.addCosts(WOOD, WOOD, WOOD, STONE, LOOM);
        magistratesGuild.addBonuses(
                new CardBonus(CIVILIAN_STRUCTURE, 0, 1, LEFT),
                new CardBonus(CIVILIAN_STRUCTURE, 0, 1, RIGHT)
        );
        addGuild(magistratesGuild);

        Card buildersGuild = createCard(GUILD, "builders guild");
        buildersGuild.addCosts(STONE, STONE, CLAY, CLAY, GLASS);
        buildersGuild.addBonuses(
                new WonderBonus(0, 1, LEFT),
                new WonderBonus(0, 1, RIGHT),
                new WonderBonus(0, 1, ME)
        );
        addGuild(buildersGuild);
    }
}
