package model.bonuses;

import model.Bonus;
import model.Resource;
import model.wonderboards.WonderBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiResource implements Bonus {

    private List<Resource> resources;

    public MultiResource(Resource... resources) {
        if (resources == null || resources.length < 2)
            throw new IllegalArgumentException("A multi resource must be contains at least 2 resources");
        this.resources = Arrays.asList(resources);
    }

    public List<Resource> getResources() {
        return resources;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addMultiResource(this);
    }
}
