package model.wonderboards;

import java.util.ArrayList;
import java.util.List;

public class WonderBoard {

    private City city;

    private Side side;

    List<Step> steps = new ArrayList<>();

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

    public void addStep(Step step) {
        steps.add(step);
    }

    @Override
    public String toString() {
        return city + " " + side;
    }
}
