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
    Scanner stringScanner = new Scanner(System.in);
    Ship ship;
    ArrayList<Ship> ships;


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

    public void allShips() {
        ships = new ArrayList<>();
        ships.add(new Ship(2));
        ships.add(new Ship(2));
        ships.add(new Ship(2));
        ships.add(new Ship(2));
        ships.add(new Ship(3));
        ships.add(new Ship(3));
        ships.add(new Ship(3));
        ships.add(new Ship(4));
        ships.add(new Ship(4));
        ships.add(new Ship(5));
    }

    public void printAllShips() {
        System.out.println("AVAILABLE SHIPS");
        for (Ship s : ships) {
            if(!s.isPlacedOnBattlefield())
            System.out.println("You have available ship: " + s.getShipType() + " to place -" + !s.isPlacedOnBattlefield());
        }
        System.out.println("");
        System.out.println("PLACED SHIPS");
        for (Ship s : ships) {
            if(s.isPlacedOnBattlefield())
            System.out.println(" You have placed ship:" + s.getShipType() + " placed.");
        }
    }
    public void addShipsOnBattlefield() {

    }
}

