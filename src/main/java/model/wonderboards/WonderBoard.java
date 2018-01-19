package model.wonderboards;

import model.resources.Resource;
import model.resources.ResourceType;

import java.util.ArrayList;
import java.util.List;

public class WonderBoard {

    private City city;

    private Side side;

    List<Resource> resources = new ArrayList<>();

    public WonderBoard(City city, Side side) {
        if (city == null)
            throw new IllegalArgumentException("The wonderboard's city cannot be null");
        if (city == null)
            throw new IllegalArgumentException("The wonderboard's side cannot be null");
        this.city = city;
        this.side = side;
    }

    public City getCity() {
        return city;
    }

    public Side getSide() {
        return side;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    @Override
    public String toString() {
        return city + " " + side;
    }

    public boolean has(ResourceType type) {
        return has(type, 1);
    }

    public boolean has(ResourceType type, int count) {
        int total = 0;
        for (Resource resource : resources) {
            if (resource.is(type))
                total++;
        }
        return total >= count;
    }
}
