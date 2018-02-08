package model.bonuses;

import model.Bonus;
import model.Direction;
import model.Resource;
import model.wonderboards.WonderBoard;

import java.util.Arrays;
import java.util.List;

public class Discount implements Bonus {

    private Direction direction;

    private int cost;

    private List<Resource> resources;


    public Discount(Direction direction, int cost, Resource... resources) {
        this.direction = direction;
        this.cost = cost;
        this.resources = Arrays.asList(resources);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCost() {
        return cost;
    }

    public List<Resource> getResources() {
        return resources;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addDiscount(this);
    }
}
