
public class Ship {
    private int xCoordinate;
    private int yCoordinate;
    private int shipDirection;
    private int shipType;
    private boolean placedOnBattlefield;
    private int shipCount;

    public Ship(int shipType, int xCoordinate, int yCoordinate, int shipDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.shipDirection = shipDirection;
        this.shipType = shipType;
    }

    public Ship() {

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

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }

    public int getShipCount() {
        return shipCount;
    }

    public boolean isPlacedOnBattlefield() {
        return placedOnBattlefield;
    }

    public void setPlacedOnBattlefield(boolean placedOnBattlefield) {
        this.placedOnBattlefield = placedOnBattlefield;
    }


}