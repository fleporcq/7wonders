package model.wonderboards;

import model.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WonderBoardFactory {

    public List<WonderBoard> getRandomWonderBoards() {
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
        Resource baseResource = null;
        switch (city) {
            case GIZAH:
                baseResource = Resource.STONE;
                break;
            case RHODES:
                baseResource = Resource.ORE;
                break;
            case BABYLON:
                baseResource = Resource.CLAY;
                break;
            case EPHESOS:
                baseResource = Resource.PAPYRUS;
                break;
            case OLYMPIA:
                baseResource = Resource.WOOD;
                break;
            case ALEXANDRIA:
                baseResource = Resource.GLASS;
                break;
            case HALIKARNASSOS:
                baseResource = Resource.LOOM;
                break;
        }
        wonderBoard.addResource(baseResource);
        return wonderBoard;
    }

}
