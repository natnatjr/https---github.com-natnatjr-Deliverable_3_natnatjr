package com.example;

import java.util.Scanner;

/**
 * 
 * @author Edwin Natnat Jr
 * @version 1.0
 *          This class is the main class of the "Card Matching Game"
 *          application.
 */
public class CardMatchingGame {
    public static String[][] cards = new String[4][4];
    public static String[][] board = new String[4][4];

    public static Scanner scanner = new Scanner(System.in);

    public enum DeckCards {

        A, B, C, D, E, F, G, H;
    }

    public static void printBoard() {

        for (int i = 0; i < 4; i++) {
            System.out.println("  |  ");
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + "  |  ");
            }
            System.out.println();
        }
    }

    // store the DeckCards in the board with shuffleDeck() method
    public static void shuffleDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int random = (int) (Math.random() * 8);
                board[i][j] = DeckCards.values()[random].toString();
            }
        }
    }

    // create a method that will check if the user's input is valid with parameters
    // String [][] board, int row, int col
    public static boolean isValid(String[][] board, int row, int col) {
        if (row < 0 || row > 3 || col < 0 || col > 3) {
            return false;
        }
        if (board[row][col] == null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        shuffleDeck();
        System.out.println("Welcome to the Card Matching Game!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");

        // asks user to enter the row and column of the card
        System.out.println("Please enter the row and column of the card you want to flip: ");
        System.out.println("Row: ");
        int row = scanner.nextInt();
        System.out.println("Column: ");
        int col = scanner.nextInt();

        // check if the user's input is valid
        if (isValid(board, row, col)) {
            System.out.println("You flipped the " + board[row][col] + " card!");
            // store the card in the cards array
            cards[row][col] = board[row][col];
            // set the card in the board to null
            board[row][col] = null;
            // print the board
            printBoard();
        } else {
            System.out.println("Invalid input!");
        }

    }
}
