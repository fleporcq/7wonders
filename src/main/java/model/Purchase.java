package model;

public class Purchase implements Payment {

    private Resource resource;

    private Direction direction;

    public Purchase(Resource resource, Direction direction) {
        if (resource == null)
            throw new IllegalArgumentException("The resource cannot be null");
        if (direction == null)
            throw new IllegalArgumentException("The direction cannot be null");
        this.resource = resource;
        this.direction = direction;
    }

    public Resource getResource() {
        return resource;
    }

    public Direction getDirection() {
        return direction;
    }
}
