package main.java;

public class GameController {
    Battlefield battlefield1;
    Battlefield battlefield2;

    public GameController() {
        System.out.println("Creating battlefield 1");
        battlefield1 = new Battlefield();
        System.out.println("\n Creating battlefield 2");
        battlefield2 = new Battlefield();
    }

}
