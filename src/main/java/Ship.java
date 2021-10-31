package main.java;
public class Ship {
    private int xCoordinate;
    private int yCoordinate;
    private int shipDirection;
    private int shipType;
    private boolean placedOnBattlefield;

    public Ship(int shipType, int xCoordinate, int yCoordinate, int shipDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.shipDirection = shipDirection;
        this.shipType = shipType;
    }

    public Ship(int shipType) {
        this.shipType = shipType;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getShipDirection() {
        return shipDirection;
    }

    public int getShipType() {
        return shipType;
    }

    public boolean isPlacedOnBattlefield() {
        return placedOnBattlefield;
    }

    public void setPlacedOnBattlefield(boolean placedOnBattlefield) {
        this.placedOnBattlefield = placedOnBattlefield;
    }

}