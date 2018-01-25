package model.resources;

import model.Bonus;
import model.Cost;
import model.wonderboards.WonderBoard;

public class Resource implements Bonus, Cost {

    private ResourceType type;

    public Resource(ResourceType type) {
        if (type == null)
            throw new IllegalArgumentException("The resource's type cannot be null");
        this.type = type;
    }

    @Override
    public void apply(WonderBoard wonderBoard) {
        wonderBoard.addResource(this);
    }

    public boolean is(ResourceType type) {
        return this.type == type;
    }

    @Override
    public void pay(WonderBoard wonderBoard) {

    }
}
