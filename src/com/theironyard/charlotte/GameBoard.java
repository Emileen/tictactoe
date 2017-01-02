package com.theironyard.charlotte;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by emileenmarianayagam on 12/27/16.
 */
public class GameBoard {
    public static Scanner input = new Scanner(System.in);
    //created a board that has an array of 3 and three
    char[][] gameBoard;

    public GameBoard() {
        //constructor that is going to create the criteria for the game bord to be
        // 3X3
        //in here we are also created an empty board
        this.gameBoard = new char[3][3];
        createBoard();
    }


    public void createBoard() {
        //sets the gameboard to empty
        //created a loop that goes through the legth of the array
        //created a board that is able to be 3 x 3
        //gameBoard.length or gameBoard[i].length
        for (int a = 0; a < 3; a++) {
            // fills the game board with blank spaces
            Arrays.fill(gameBoard[a], ' ');
        }
    }

    public boolean boardFull(){
        for (int a = 0; a < gameBoard.length; a++) {
            for (int b = 0; b<gameBoard.length; b++)
            // fills the game board with blank spaces
                gameBoard[a][b] = '-';
            return true;

        }
        return false;
    }


    public void printBoard() {
        //creates a game board
        //this puts the columnumbers
        System.out.println("   1   2   3");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            //print out the row numbers
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < 3; j++) {
                //prints the | at the designated location
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
            //prints the line before going to the next row
            System.out.println("-------------");
        }
    }

    public void playerInput(int row, int column, char player) {
//putting the x's and o's in the designated spots that were choosen by the player
        // starts the rows and column at 0 and goes to 2
        if (row >= 0 && row <= 3 && column >= 0 && column <= 3) {
            if (gameBoard[row - 1][column - 1] == ' ') {
                gameBoard[row - 1][column - 1] = player;
                printBoard();
            } else {
                System.out.println("spot already taken ");
            }
        } else {
            System.out.println("you are out of bound");
        }

    }

    //check to see if there are any winners on the board- vertical, horizontal and diagonal
    public boolean winnerOfGame() {
        if (checkDiagnolWin() || checkColumnWinner() || checkRowWinner()) {
            return true;
        }
        return false;
    }

    // check horizontally if there is a win
    public boolean checkRowWinner() {
            //keep the column same and check if there are winners
        for (int i = 0; i < gameBoard.length; i++) {
            if (checkRowCol(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2]) == true) {
                //if there are return true else false
                System.out.println( "player " + gameBoard [i][0] + " is the winner " );
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnWinner() {
        for (int i = 0; i < gameBoard.length; i++) {
            //keep the row the same and check the column
            if (checkRowCol(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i]) == true) {
                System.out.println( "player " + gameBoard [0][i] + " is the  winner " );
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagnolWin() {
            //checks to see if there are any diagnoal winn
        if (((checkRowCol(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) == true||
                (checkRowCol(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]) == true)))){
            System.out.println("we have a winner player " + gameBoard[1][1]);
           return true;
        }
       return false;
    }


    // checks to see if all the three values that are in the box is the same and is not empty
    //boolean methods evalue the method and check if its true or false
    private boolean checkRowCol(char space1, char space2, char space3) {
        return ((space1 != ' ') && (space1 == space2) && (space2 == space3));

    }
}



