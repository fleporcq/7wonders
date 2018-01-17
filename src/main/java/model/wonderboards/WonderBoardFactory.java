package model.wonderboards;

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
        switch (city) {
            case GIZAH:
                break;
            case RHODES:
                break;
            case BABYLON:
                break;
            case EPHESOS:
                break;
            case OLYMPIA:
                break;
            case ALEXANDRIA:
                break;
            case HALIKARNASSOS:
                break;
        }
        return wonderBoard;
    }

}
