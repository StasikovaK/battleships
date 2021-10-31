package main.java;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Battlefield {
    public String PlayerName1;
    public String PlayerName2;
    public int[][] battlefield;
    Scanner scanner = new Scanner(System.in);
    Ship ship;
    ArrayList<Ship> ships;
    public int shotCounter = 0;


    public Battlefield() {
        battlefield = new int[10][10];
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " -");
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

    public void allShips() {
        ships = new ArrayList<>();
       ships.add(new Ship(2));
//        ships.add(new Ship(2));
//        ships.add(new Ship(2));
//        ships.add(new Ship(2));
//        ships.add(new Ship(3));
//        ships.add(new Ship(3));
//        ships.add(new Ship(3));
//        ships.add(new Ship(4));
//        ships.add(new Ship(4));
  //      ships.add(new Ship(5));
    }

    public void printAllShips() {
        System.out.println("AVAILABLE SHIPS");
        for (Ship s : ships) {
            if (!s.isPlacedOnBattlefield())
                System.out.println("You have available ship: " + s.getShipType() + " to place -" + !s.isPlacedOnBattlefield());
        }
        System.out.println("");
        System.out.println("PLACED SHIPS");
        for (Ship s : ships) {
            if (s.isPlacedOnBattlefield())
                System.out.println(" You have placed ship:" + s.getShipType() + " placed.");
        }
    }

    public void addShipsOnBattlefield() {
        System.out.println("Choose ship to add: ");
        for (Ship s : ships) {
            System.out.println("Insert start X coordinate");
            int x = scanner.nextInt();
            System.out.println("Insert start y coordinate");
            int y = scanner.nextInt();
            System.out.println("Choose direction: " +
                    "1. Vertical" +
                    "2. Horizontal");
            int direction = scanner.nextInt();

            for (int i = 0; i < s.getShipType(); i++) {
                if (direction == 1) {
                    battlefield[x + i][y] = 2;
                } else {
                    battlefield[x][y + i] = 2;
                }
            }
            printBattlefield();
        }
    }

    public void makeShot() {
        do {
            System.out.println("Choose field to shoot at!");
            System.out.println("Insert X coordinate");
            int x = scanner.nextInt();
            System.out.println("Insert Y Coordinate");
            int y = scanner.nextInt();
            if (battlefield[y][x] == 2) {
                System.out.println("Hit");
                battlefield[y][x] = 1;
                shotCounter++;
                printBattlefield();
                winCondition();
            } else {
                System.out.println("Miss");
                break;
            }
        }
        while (true);
    }

    public boolean winCondition() {
        int shipDeckSum = 0;
        for(Ship s: ships) {
            shipDeckSum = s.getShipType() + shipDeckSum;
        }
        if (shotCounter == shipDeckSum) {
            System.out.println("YOU ARE THE WINNER!");
            return true;
        } return false;

    }
}