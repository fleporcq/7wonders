package model.wonderboards;

public class WonderBoard {

    private String name;

    private Side side;

    public WonderBoard(String name, Side side) {
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("The wonderboard's name cannot be null or empty");
        if (side == null)
            throw new IllegalArgumentException("The wonderboard's side cannot be null");
        this.name = name;
        this.side = side;
    }

    public String getName() {
        return name;
    }

    public Side getSide() {
        return side;
    }
}
