package main.java;

import java.io.IOException;

public class GameController {
    Battlefield battlefield1;
    Battlefield battlefield2;

    public GameController() {
        battlefield1 = new Battlefield();
        battlefield2 = new Battlefield();

    }
    public void welcomePlayer(){
        battlefield1.welcomePlayer();
        battlefield2.welcomePlayer();

    }
    public void createBattlefield(){
        System.out.println("Creating battlefield for Player " + battlefield1.playerName);
        battlefield1.drawField();
        System.out.println("\n Creating battlefield  for Player " + battlefield2.playerName);
        battlefield2.drawField();
    }
    public void prepareField () {
        battlefield1.addShipsOnBattlefield();
        battlefield2.addShipsOnBattlefield();
        clearScreen();
    }
    public void startGame() {
        while (true) {
            clearScreen();
        battlefield1.makeShot(battlefield2.battlefield);
            if (battlefield1.winCondition()) {
                break;
            }
            clearScreen();
        battlefield2.makeShot(battlefield1.battlefield);
        if (battlefield2.winCondition())
        break;
        }
    }
    public static void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
    }
