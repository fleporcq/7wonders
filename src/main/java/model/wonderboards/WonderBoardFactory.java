package model.wonderboards;

import model.resources.Resource;
import model.resources.ResourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WonderBoardFactory {

    public List<WonderBoard> shuffle() {
        List<WonderBoard> wonderBoards = new ArrayList<>();
        Random random = new Random();
        for (City city : City.values()) {
            Side side = random.nextBoolean() ? Side.A : Side.B;
            wonderBoards.add(getWonderBoard(city, side));
        }
        return wonderBoards;
    }

    public WonderBoard getWonderBoard(City city, Side side) {
        WonderBoard wonderBoard = new WonderBoard(city, side);
        ResourceType baseResource = null;
        switch (city) {
            case GIZAH:
                baseResource = ResourceType.STONE;
                break;
            case RHODES:
                baseResource = ResourceType.ORE;
                break;
            case BABYLON:
                baseResource = ResourceType.CLAY;
                break;
            case EPHESOS:
                baseResource = ResourceType.PAPYRUS;
                break;
            case OLYMPIA:
                baseResource = ResourceType.WOOD;
                break;
            case ALEXANDRIA:
                baseResource = ResourceType.GLASS;
                break;
            case HALIKARNASSOS:
                baseResource = ResourceType.LOOM;
                break;
        }
        wonderBoard.addResource(new Resource(baseResource));
        return wonderBoard;
    }

}
