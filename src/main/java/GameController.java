

import java.io.IOException;
import java.util.Scanner;

public class GameController {
    Battlefield battlefield1;
    Battlefield battlefield2;
    Battlefield computerBattlefield;
    Scanner scanner = new Scanner(System.in);
    int gameMode;

    public GameController() {
        battlefield1 = new Battlefield();
        battlefield2 = new Battlefield();
        computerBattlefield = new Battlefield();
    }

    public int chooseGameMode() {
        System.out.println("WELCOME TO THE GAME BATTLEFIELD");
        System.out.println("Choose game mode:");
        int gameMode;
        do {
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("Please insert selected mode number:");
            gameMode = scanner.nextInt();
            switch (gameMode) {
                case 1:
                    System.out.println("You selected game mode Player vs Player");
                    break;
                case 2:
                    System.out.println("You selected game mode Player vs Computer");
                    break;
            }
        } while (gameMode != 1 && gameMode != 2);
        return gameMode;
    }

    public void welcomePlayer() {
        gameMode = chooseGameMode();
        if (gameMode == 1) {
            battlefield1.welcomePlayer();
            battlefield2.welcomePlayer();
        } else if (gameMode == 2) {
            computerBattlefield.welcomeComputer();
            battlefield1.welcomePlayer();
        }
    }

    public void createBattlefield() {
        System.out.println("Creating battlefield for Player " + battlefield1.playerName);

        if (gameMode == 1) {

            System.out.println("\n Creating battlefield  for Player " + battlefield2.playerName);
            battlefield2.drawField();
        } else {
            System.out.println("Creating battlefield for Computer " + computerBattlefield.playerName);
            computerBattlefield.drawField();
        }

    }

    public void prepareField() {
        battlefield1.addShipsOnBattlefield();
        if (gameMode == 1) {
            battlefield2.addShipsOnBattlefield();
        } else {
            computerBattlefield.computerAddShips();
        }

    }

    public void startGame() {
        if (gameMode == 1) {
            while (true) {
                battlefield1.makeShot(battlefield2.battlefield);
                if (battlefield1.winCondition()) {
                    break;
                }
                battlefield2.makeShot(battlefield1.battlefield);
                if (battlefield2.winCondition()) {
                    break;
                }
            }
        }
        if (gameMode == 2) {
            while (true) {
                battlefield1.makeShot(computerBattlefield.battlefield);
                if (battlefield1.winCondition()) {
                    break;
                }
                computerBattlefield.computerMakesShot(battlefield1.battlefield);
                if (computerBattlefield.winCondition())
                    break;
            }
        }
    }

}
