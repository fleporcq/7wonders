package model.cards;

import model.Age;
import model.resources.Resource;

import static model.cards.CardType.*;
import static model.resources.ResourceType.*;

public class DeckAgeIII extends Deck {

    public DeckAgeIII(int playerCount) {
        super(Age.III, playerCount);
    }

    @Override
    protected void build() {
        Card pantheon = createCard(CIVILIAN_STRUCTURE, "pantheon");
        pantheon.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(ORE), new Resource(PAPYRUS), new Resource(LOOM), new Resource(GLASS));
        add(pantheon, 3, 6);

        Card gardens = createCard(CIVILIAN_STRUCTURE, "gardens");
        gardens.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(WOOD));
        add(gardens, 3, 4);

        Card townHall = createCard(CIVILIAN_STRUCTURE, "town hall");
        townHall.addCosts(new Resource(STONE), new Resource(STONE), new Resource(ORE), new Resource(GLASS));
        add(townHall, 3, 5, 6);

        Card palace = createCard(CIVILIAN_STRUCTURE, "palace");
        palace.addCosts(new Resource(CLAY), new Resource(WOOD), new Resource(ORE), new Resource(STONE), new Resource(GLASS), new Resource(PAPYRUS), new Resource(LOOM));
        add(palace, 3, 7);

        Card senate = createCard(CIVILIAN_STRUCTURE, "senate");
        senate.addCosts(new Resource(WOOD), new Resource(WOOD), new Resource(ORE), new Resource(STONE));
        add(senate, 3, 5);

        Card haven = createCard(COMMERCIAL_STRUCTURE, "haven");
        haven.addCosts(new Resource(ORE), new Resource(WOOD), new Resource(LOOM));
        add(haven, 3, 4);

        Card lighthouse = createCard(COMMERCIAL_STRUCTURE, "lighthouse");
        lighthouse.addCosts(new Resource(STONE), new Resource(GLASS));
        add(lighthouse, 3, 6);

        Card chamberOfCommerce = createCard(COMMERCIAL_STRUCTURE, "chamber of commerce");
        chamberOfCommerce.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(PAPYRUS));
        add(chamberOfCommerce, 4, 6);

        Card arena = createCard(COMMERCIAL_STRUCTURE, "arena");
        arena.addCosts(new Resource(STONE), new Resource(STONE), new Resource(ORE));
        add(arena, 3, 5, 7);

        Card fortifications = createCard(MILITARY_STRUCTURE, "fortifications");
        fortifications.addCosts(new Resource(ORE), new Resource(ORE), new Resource(ORE), new Resource(STONE));
        add(fortifications, 3, 7);

        Card circus = createCard(MILITARY_STRUCTURE, "circus");
        circus.addCosts(new Resource(STONE), new Resource(STONE), new Resource(ORE));
        add(circus, 4, 5, 6);

        Card arsenal = createCard(MILITARY_STRUCTURE, "arsenal");
        arsenal.addCosts(new Resource(ORE), new Resource(WOOD), new Resource(WOOD), new Resource(LOOM));
        add(arsenal, 3, 4, 7);

        Card siegeWorkshop = createCard(MILITARY_STRUCTURE, "siege workshop");
        siegeWorkshop.addCosts(new Resource(WOOD), new Resource(CLAY), new Resource(CLAY), new Resource(CLAY));
        add(siegeWorkshop, 3, 5);

        Card lodge = createCard(SCIENTIFIC_STRUCTURE, "lodge");
        lodge.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(LOOM), new Resource(PAPYRUS));
        add(lodge, 3, 6);

        Card observatory = createCard(SCIENTIFIC_STRUCTURE, "observatory");
        observatory.addCosts(new Resource(ORE), new Resource(ORE), new Resource(GLASS), new Resource(LOOM));
        add(observatory, 3, 7);

        Card university = createCard(SCIENTIFIC_STRUCTURE, "university");
        university.addCosts(new Resource(WOOD), new Resource(WOOD), new Resource(PAPYRUS), new Resource(GLASS));
        add(university, 3, 4);

        Card academy = createCard(SCIENTIFIC_STRUCTURE, "academy");
        academy.addCosts(new Resource(STONE), new Resource(STONE), new Resource(STONE), new Resource(GLASS));
        add(academy, 3, 7);

        Card study = createCard(SCIENTIFIC_STRUCTURE, "study");
        study.addCosts(new Resource(WOOD), new Resource(PAPYRUS), new Resource(LOOM));
        add(study, 3, 5);

        Card workersGuild = createCard(GUILD, "workers guild");
        workersGuild.addCosts(new Resource(ORE), new Resource(ORE), new Resource(CLAY), new Resource(STONE), new Resource(WOOD));
        add(workersGuild, 3);

        Card craftmensGuild = createCard(GUILD, "craftmens guild");
        craftmensGuild.addCosts(new Resource(ORE), new Resource(ORE), new Resource(STONE), new Resource(STONE));
        add(craftmensGuild, 3);

        Card tradersGuild = createCard(GUILD, "traders guild");
        tradersGuild.addCosts(new Resource(LOOM), new Resource(PAPYRUS), new Resource(GLASS));
        add(tradersGuild, 3);

        Card philosophersGuild = createCard(GUILD, "philosophers guild");
        philosophersGuild.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(CLAY), new Resource(LOOM), new Resource(PAPYRUS));
        add(philosophersGuild, 3);

        Card spyGuild = createCard(GUILD, "spy guild");
        spyGuild.addCosts(new Resource(CLAY), new Resource(CLAY), new Resource(CLAY), new Resource(GLASS));
        add(spyGuild, 3);

        Card strategyGuild = createCard(GUILD, "strategy guild");
        strategyGuild.addCosts(new Resource(ORE), new Resource(ORE), new Resource(STONE), new Resource(LOOM));
        add(strategyGuild, 3);

        Card shipownersGuild = createCard(GUILD, "shipowners guild");
        shipownersGuild.addCosts(new Resource(WOOD), new Resource(WOOD), new Resource(WOOD), new Resource(PAPYRUS), new Resource(GLASS));
        add(shipownersGuild, 3);

        Card scientitsGuild = createCard(GUILD, "scientits guild");
        scientitsGuild.addCosts(new Resource(WOOD), new Resource(WOOD), new Resource(ORE), new Resource(ORE), new Resource(PAPYRUS));
        add(scientitsGuild, 3);

        Card magistratesGuild = createCard(GUILD, "magistrates guild");
        magistratesGuild.addCosts(new Resource(WOOD), new Resource(WOOD), new Resource(WOOD), new Resource(STONE), new Resource(LOOM));
        add(magistratesGuild, 3);

        Card buildersGuild = createCard(GUILD, "builders guild");
        buildersGuild.addCosts(new Resource(STONE), new Resource(STONE), new Resource(CLAY), new Resource(CLAY), new Resource(GLASS));
        add(buildersGuild, 3);
    }
}
