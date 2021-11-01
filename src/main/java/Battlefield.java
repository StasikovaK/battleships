

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battlefield {
    public String playerName;
    public int[][] battlefield;
    Scanner scanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    Ship ship;
    ArrayList<Ship> ships;
    public int shotCounter = 0;
    int shipDeckSum = 0;
    Random random = new Random();

    public Battlefield() {
    }

    public void welcomePlayer() {

        System.out.println("Player, please insert your name");
        playerName = stringScanner.nextLine();
        System.out.println("Hello " + playerName);

    }

    public void welcomeComputer() {
        System.out.println("Hi! Im the Computer. Try to win me!");
        playerName = "BattleshipMaster";
    }


    public void drawField() {
        battlefield = new int[10][10];
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i);
            for (int j = 0; j < battlefield[1].length; j++) {
                System.out.print(" -");
            }
            System.out.println();
        }
    }

    public void printBattlefield() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i);
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[i][j] == 0) {
                    System.out.print(" -");
                } else if (battlefield[i][j] == 2) {
                    System.out.print(" X");
                } else if (battlefield[i][j] == 1) {
                    System.out.print(" o");
                } else {
                    System.out.print(" " + battlefield[i][j]);
                }
            }
            System.out.println();
        }
    }
    public void printEnemy(int[][] enemy) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < enemy.length; i++) {
            System.out.print(i);
            for (int j = 0; j < enemy[1].length; j++) {
                if (enemy[i][j] == 0) {
                    System.out.print(" -");
                } else if (enemy[i][j] == 2) {
                    System.out.print(" -");
                } else if (enemy[i][j] == 1) {
                    System.out.print(" X");
                } else if(enemy[i][j] == 3) {
                    System.out.print(" o");
            }else {
                    System.out.print(" " + enemy[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void allShips() {
        ships = new ArrayList<>();
        ships.add(new Ship(1));
       ships.add(new Ship(2));
        ships.add(new Ship(3));
        ships.add(new Ship(4));
        for(Ship s: ships) {
            shipDeckSum = s.getShipType() + shipDeckSum;
        }
    }


    public void addShipsOnBattlefield() {
        allShips();
        drawField();
        System.out.println(playerName + " Choose ship to add: ");
        for (Ship s : ships) {
            System.out.println("Insert start X coordinate");
            int x = scanner.nextInt();
            System.out.println("Insert start Y coordinate");
            int y = scanner.nextInt();
            System.out.println("Choose direction: " +
                    "1. Vertical" +
                    "2. Horizontal");
            int direction = scanner.nextInt();
            if (!isAvailable(x, y, s.getShipType(), direction, battlefield)) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("Coordinates do not correspond the rules of the game! Try again.");
                System.out.println("----------------------------------------------------------------");
                continue;
            }

            for (int i = 0; i < s.getShipType(); i++) {
                if (direction == 1) {
                    battlefield[y + i][x] = 2;
                } else {
                    battlefield[y][x + i] = 2;
                }
            }
            printBattlefield();
        }
    }

    public void makeShot(int[][] shot) {

        do {
            System.out.println("\n");
            System.out.println(playerName + " Choose field to shoot at!");
            System.out.println("Insert X coordinate");
            int x = scanner.nextInt();
            System.out.println("Insert Y Coordinate");
            int y = scanner.nextInt();
            if (shot[y][x] == 2) {
                System.out.println("Hit");
                shot[y][x] = 1;
                shotCounter++;
                printEnemy(shot);
                if(shotCounter == shipDeckSum){
                    break;
                }
            } else {
                shot[y][x] = 3;
                System.out.println("Miss");
                printEnemy(shot);

                break;
            }
        }
        while (true);
    }
    public void computerMakesShot(int[][] shot) {
        System.out.println("BattleshipMaster's turn");
        do {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (shot[y][x] == 2) {
                System.out.println("Hit");
                shot[y][x] = 1;
                shotCounter++;
                printEnemy(shot);

//               printBattlefield();
                if(shotCounter == shipDeckSum){
                    break;
                }
            } else {
                shot[y][x] = 3;
                System.out.println("Miss");
                printEnemy(shot);

                break;
            }
        }
        while (true);
    }

    public boolean winCondition() {

        if (shotCounter == shipDeckSum) {
            System.out.println("YOU ARE THE WINNER!");
            return true;
        } return false;

    }
    public void computerAddShips(){
        allShips();
        for (Ship s : ships) {
            int x = random.nextInt(8);
            int y = random.nextInt(8);
            int direction = (random.nextInt(1)+1);

            for (int i = 0; i < s.getShipType(); i++) {
                if (direction == 1) {
                    battlefield[y + i][x] = 2;
                } else {
                    battlefield[y][x + i] = 2;
                }
            }
            System.out.println();
//            printBattlefield();
        }

    }

    public static boolean isAvailable(int x, int y, int shipType, int direction, int[][] battlefield) {
        //check if it fits the field
        if (direction == 1) {
            if (y + shipType > battlefield.length ) {
                return false;
            }
        }
        if (direction == 2) {
            if (x + shipType > battlefield[0].length ) {
                return false;
            }
        }

//        //check if the there is enough free space around the ship
//        while (shipType != 0) {
//            for (int i = 0; i < shipType; i++) {
//                int xi = 0;
//                int yi = 0;
//                if (direction == 1) {
//                    yi = i;
//                } else {
//                    xi = i;
//                }
//
//                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0){
//                    if (battlefield[x + 1 + xi][y + yi]!=0){
//                        return false;
//                    }
//                }
//                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0){
//                    if (battlefield[x - 1 + xi][y + yi]!=0){
//                        return false;
//                    }
//                }
//                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0){
//                    if (battlefield[x + xi][y + 1 + yi]!=0){
//                        return false;
//                    }
//                }
//                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0){
//                    if (battlefield[x + xi][y - 1 + yi]!=0){
//                        return false;
//                    }
//                }
//            }
//            shipType--;
//        }
        return true;
    }

}