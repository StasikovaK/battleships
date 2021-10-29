public class Ship {
    private int width;
    private int height;
    private int [] location;
    private char shipType;

    public Ship(int width, int height, int[] location, char shipType) {
        this.width = width;
        this.height = height;
        this.location = location;
        this.shipType = shipType;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getLocation() {
        return location;
    }

    public char getShipType() {
        return shipType;
    }
}

