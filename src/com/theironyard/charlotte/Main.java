package com.theironyard.charlotte;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    boolean gameOnGoing = true;

    public static void main(String[] args) {
        char player;


        // write your code here
        System.out.println("Welcome to the Tic Tac Toe");
        GameBoard board = new GameBoard();
        String spaceLeft;
        board.printBoard();
        //board.boardFull();



        System.out.println("would you like to play x's or o's");
        player = input.next().charAt(0);

        do {
            if (player == 'x') {
                player = 'o';
            } else {
                player = 'x';
            }

            System.out.println("Pick your row [1,2,3] " + "player " + player);
            int row = input.nextInt();
            System.out.println("Pick your colunm [1,2,3] " + " player " + player);
            int column = input.nextInt();
            board.playerInput(row, column, player); //p1
            System.out.println("If there more spaces for choice - Y/N");
            spaceLeft = input.next();
            board.printBoard();
            if (board.winnerOfGame()) {
                return;
            }

        } while (spaceLeft.equalsIgnoreCase("Y"));
        System.out.println("there are no winners");


    }

}

